	@RequestMapping(value= {"/{id:(?!assets).*}","/{id:(?!assets).*}/{categoryNo}","/{id:(?!assets).*}/{categoryNo}/{postNo}"})
	public String blogMain(
			@PathVariable(value="id") String id,
			@PathVariable(value="categoryNo") Optional<String> categoryNo,
			@PathVariable(value="postNo") Optional<String> postNo,
			ModelMap model) {
		/*
			Map<String, Object> blogContents = blogService.getBlogContents(String id, Optional<String> categoryNo, Optional<String> postNo);
		*/
		Map<String, Object> urlData = new HashMap<String, Object>();
		urlData.put("id", id);
		urlData.put("categoryNo", categoryNo);
		urlData.put("postNo", postNo);
		
		Map<String, Object> blogContents = blogService.getBlogContents(urlData);
		model.addAttribute("blogContents", blogContents);
		
		if(blogContents.get("blogVo")==null) {
			model.addAttribute("message", "존재하지 않는 사용자 입니다.");
			model.addAttribute("url", "main");
			return "main/redirect";
		}
		
		
		return "blog/blog-main";
	}
	
	
	public Map<String, Object> getBlogContents(Map<String, Object> urlData) {
		
		Map<String, Object> urlDataMap = new HashMap<String, Object>();
		urlDataMap.put("userId", ""+urlData.get("id"));
		
		BlogVo blogVo = blogDao.get(urlDataMap);
		
		List<CategoryVo> categoryList = categoryDao.getList(urlDataMap);
		
		/*
			공통 기능들을 밖으로 뺄 수 있었다면
			Optional<String> urlDataCategoryNo = (Optional<String>) urlData.get("categoryNo");
			String isCategoryNo = urlDataCategoryNo.isPresent() ? urlDataCategoryNo.get() : "-1";
			long categoryNo = isNumeric(isCategoryNo) ? Long.parseLong(isCategoryNo) : -1L;
			
			Optional<String> urlDataPostNo = (Optional<String>) urlData.get("postNo");
			String isPostNo = urlDataPostNo.isPresent() ? urlDataPostNo.get() : "-1";
			long postNo = isNumeric(isPostNo) ? Long.parseLong(isPostNo) : -1L;
			
			public 
		*/
		Optional<String> urlDataCategoryNo = (Optional<String>) urlData.get("categoryNo");
		String isCategoryNo = urlDataCategoryNo.isPresent() ? urlDataCategoryNo.get() : "-1";
		long categoryNo = isNumeric(isCategoryNo) ? Long.parseLong(isCategoryNo) : -1L;
		/*
			재사용 좋지않음
		*/
		urlDataMap.put("categoryNo", categoryNo);
		List<PostVo> postList = postDao.getList(urlDataMap);

		Optional<String> urlDataPostNo = (Optional<String>) urlData.get("postNo");
		String isPostNo = urlDataPostNo.isPresent() ? urlDataPostNo.get() : "-1";
		long postNo = isNumeric(isPostNo) ? Long.parseLong(isPostNo) : -1L;
		urlDataMap.put("postNo", postNo);
		PostVo postVo = postDao.get(urlDataMap);
		
		Map<String, Object> blogContents = new HashMap<String, Object>();
		blogContents.put("blogVo", blogVo);
		blogContents.put("categoryList", categoryList);
		blogContents.put("postList", postList);
		blogContents.put("postVo", postVo);
		blogContents.put("selectedCategoryNo", categoryNo);
		
		return blogContents;
	}