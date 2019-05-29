
## 4조 엄기윤, 하지승, 임혜승, 이인행, 강수진

## 리펙토링의 특징
 1. 소프트웨어를 더 이해하기 쉽고 수정하기 쉽게 만듬
 2. 소프트웨어 기능에 영향을 주지 않는다.(성능향상x, 하지만 튜닝하기 쉬워지기 때문에 성능 향상을 기대해도됨)
 3. 코드를 수정하면서 목적을 잊어선 안된다
 
 
 인다이렉션 : 간접접근 
 인다이렉션이 필요한 곳에는 쓰고 필요치 않은곳에서는 해제한다. 
 어떻게 구분? 한 곳에만 사용되는 인다이렉션은 빼주자. 
 
 주석이 필요할 것 같다면 주석대신 메서드를 추가
 조건문, 루프 메서드로 
 
 
결합도와 응집도~  

if(endIndex != -1) {
			String id = request.getRequestURL().substring(firstIndex, endIndex);
			if(id.equals(authUser.getId())) {
				authUser.setHostCheck(id);				
			}
			session.setAttribute("authUser", authUser);
		} else {
			String id = request.getRequestURL().substring(firstIndex, request.getRequestURL().length());
			
		}
 
