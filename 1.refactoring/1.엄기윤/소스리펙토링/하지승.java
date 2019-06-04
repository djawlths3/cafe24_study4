// 회원 블로그로 이동
	@GetMapping({ "", "/{pathVariable}", "/{pathVariable1}/{pathVariable2}" })
	public String userBlog(@PathVariable Optional<String> blogid, @PathVariable Optional<Integer> pathVariable,
			@PathVariable Optional<Integer> pathVariable1, @PathVariable Optional<Integer> pathVariable2,
			ModelMap modelMap, BlogVo blogVo) {
		//사용자 있나 없나 체크
		UserVo usercheck = blogService.checkUser(blogid);
		if(usercheck==null) {
			return "/main/error";
		}
		modelMap.put("pathVariable", pathVariable);
		modelMap.put("pathVariable1", pathVariable1);
		modelMap.put("pathVariable2", pathVariable2);

		Map<Object, Object> result = blogService.get(modelMap);

		BlogVo resultBlogVo = (BlogVo) result.get("blogVoGet");
		List<CategoryVo> resultCategoryVo = (List<CategoryVo>) result.get("categoryVo");
		List<PostVo> resultPostVo = (List<PostVo>) result.get("postVoList");
		PostVo postVoOne = (PostVo) result.get("postVoOne");
		
		modelMap.addAttribute("resultBlogVo", resultBlogVo);
		modelMap.addAttribute("resultCategoryVo", resultCategoryVo);
		modelMap.addAttribute("resultPostVo", resultPostVo);
		modelMap.addAttribute("postVoOne", postVoOne);

		return "blog/blog-main";
	}
	
	
	public Map<Object, Object> get(ModelMap modelMap) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		Optional<Integer> optional = (Optional<Integer>) modelMap.get("pathVariable");
		Optional<Integer> optional1 = (Optional<Integer>) modelMap.get("pathVariable1");
		Optional<Integer> optional2 = (Optional<Integer>) modelMap.get("pathVariable2");

		BlogVo blogVo = (BlogVo) modelMap.get("blogVo");
		modelMap.put("blogid", ((BlogVo) modelMap.get("blogVo")).getBlogid());

		if (optional.isPresent()) {
			modelMap.put("c_no", optional.get());
		} else if (optional1.isPresent()) {
			modelMap.put("c_no", optional1.get());
			modelMap.put("p_no", optional2.get());
		}

		map.put("blogVoGet", blogDao.get(blogVo));
		map.put("categoryVo", categoryDao.getList(blogVo, modelMap));
		map.put("postVoList", postDao.getList(modelMap));
		map.put("postVoOne", postDao.getOne(modelMap));

		return map;
	}