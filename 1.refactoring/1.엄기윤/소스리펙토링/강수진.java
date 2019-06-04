
	//블로그가기
	@RequestMapping(value= {"","/{c_no}","/{c_no}/{p_no}"})
	public String goToBlog(@PathVariable(value="id")String id,
							@PathVariable(value="c_no")Optional<Long> c_no,
							@PathVariable(value="p_no")Optional<Long> p_no,
							ModelMap modelMap) {
		//블로그 정보
		BlogVo blogVo = blogService.getAdminBlog(id);
		modelMap.put("blogVo", blogVo);
		//카테고리 목록
		List<CategoryVo> categoryList = blogService.getCategory(id);
		modelMap.put("categoryList", categoryList);
		
		//PathVariable의 기본 값 셋팅
		Long category_no = c_no.isPresent()?c_no.get():0;
		Long post_no = p_no.isPresent()?p_no.get():0;
		
		//화면에 보여질 페이지 
		PostVo postVo = blogService.getPost(id,category_no,post_no);
		modelMap.put("postVo",postVo);
		
		//화면에 보여질 카테고리에 해당하는 포스트 리스트
		List<PostVo> postList = blogService.getPostList(category_no,id);
		modelMap.put("postList", postList);
		//포스트 리스트 이동을 위한 id
		modelMap.put("adminId", id);
		
		return "blog/blog-main";
	}