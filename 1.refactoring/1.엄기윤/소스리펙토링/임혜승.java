		// 카테고리와 번호로 접근 
	@ExceptionHandler(PathException.class)
 	@RequestMapping(value= {"/{categoryNo}/{postNo}"})
	public String blog(@PathVariable(value="id") String id
			,@PathVariable Optional<Integer> categoryNo
			,@PathVariable Optional<Integer> postNo
			,Model model
			) {
		System.out.println("blog|  \"/{categoryNo}/{postNo}");
 		
 		List<CategoryVo> categoryVo=categoryService.getCategoryList(id);
 		PostVo firstPost=postService.getPostByNo(id,categoryNo.get(),postNo.get());
 		BlogVo blogVo=blogService.getBlog(id);

 		// 해당 카테고리에 그 글이 없다면 그 카테고리의 리스트를 보여주기 
 		if(firstPost==null) {
			model.addAttribute("fail",JSONResult.fail("해당 페이지가 존재하지 않습니다."));
  			return "redirect:/"+id+"/"+categoryNo.get();
 		}
		List<PostVo> postVo=postService.getAllListByCategory(id,categoryNo);
		model.addAttribute("firstPost,",firstPost);
		model.addAttribute("categoryVo",categoryVo);
		model.addAttribute("postVo",postVo);
		model.addAttribute("blogVo",blogVo);
 		return "blog/blog-main";
	}
	
		// 메인에 접근 
	@RequestMapping(value= {""})
	public String mainBlog(@PathVariable(value="id") String id
			,Model model
			) {
		System.out.println("blog| /id} "+id);
 		List<CategoryVo> categoryVo=categoryService.getCategoryList(id);
		List<PostVo> postVo=postService.getRecentlyAllList(id);
 		BlogVo blogVo=blogService.getBlog(id);

		model.addAttribute("categoryVo",categoryVo);
		model.addAttribute("postVo",postVo);
		model.addAttribute("blogVo",blogVo);
		model.addAttribute("firstVo",postVo.get(0));
		return "blog/blog-main";
	}
	
	
			// 카테고리로   접근 
	@ExceptionHandler(PathException.class)
		@RequestMapping(value= {"/{categoryNo}"})
		public String blogByCategoryNo(@PathVariable(value="id") String id,@PathVariable Optional<Integer> categoryNo
				,Model model
				) {
			System.out.println("blog| /id/categoryNo}");
	 		List<CategoryVo> categoryVo=categoryService.getCategoryList(id);
			List<PostVo> postVo=postService.getAllListByCategory(id,categoryNo);
	 		BlogVo blogVo=blogService.getBlog(id);

			// 해당 카테고리가 없다면 메인으로 가라 ( 전체글 보여주기) 
 			if(postVo.size()==0) {
 				model.addAttribute("fail",JSONResult.fail("해당 페이지가 존재하지 않습니다."));
 				return "redirect:/"+id;
			}

			model.addAttribute("categoryVo",categoryVo);
			model.addAttribute("postVo",postVo);
			model.addAttribute("firstVo",postVo.get(0));
			model.addAttribute("blogVo",blogVo);
			return "blog/blog-main";
		}
		
		
			// 번호를 눌렀을 때 글 가져오기
	@ResponseBody
	@RequestMapping("/post")
 	public JSONResult getPostByNo(@PathVariable(value="id") String id,int category_no, int no) {
 		Map<Object,Object> map=new HashMap<Object, Object>();
		List<CategoryVo> categoryVo=categoryService.getCategoryList(id);
 		PostVo firstPost=postService.getPostByNo(id,category_no,no);
 		BlogVo blogVo=blogService.getBlog(id);
		System.out.println("getPostByNo| /post  No:"+firstPost);
		map.put("firstPost", firstPost);
	   map.put("categoryVo", categoryVo);
	    map.put("blogVo", blogVo);
		return   JSONResult.success(map);
	}