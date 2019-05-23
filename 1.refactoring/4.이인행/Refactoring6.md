# 메서드 추출
- 메서드에서 거의 모든 문제점은 장황한 메서드로 인해 생긴다.
- 장황한 메서드에는 많은 정보가 들어 있는데, 마구 얽힌 복잡한 로직에 이 정보들이 묻혀버린다.
- 어떤 코드를 그룹으로 묶어도 되겠다고 판단될 땐 그 코드를 빼내어 목적을 잘 나타내는 직관적 이름의 메서드로 만들도록 한다.
- 메서드가 너무 길거나 코드에 주석들 달아야만 의도를 이해할 수 있을 때, 그 코드를 빼내어 별도의 메서드로 만든다.
- 직관적인 이름의 간결한 메서드가 좋은 이유는 다음과 같다.
  - 메서드가 적절히 잘게 쪼개져 있으면 다른 메서드에서 쉽게 사용할 수 있다.
  - 상위 계층의 메서드에서 주석 같은 더 많은 정보를 읽어들일 수 있다.
  - 재정의하기도 훨씬 수월하다.

### 방법
- 목적에 부합하는 이름의 새 메서드를 생성한다. 이때 메서드명은 원리가 아니라 기능을 나타내는 이름이어야 한다.
- 기존 메서드에서 빼낸 코드를 새로 생성한 메서드로 복사한다.
- 빼낸 코드에서 기존 메서드의 모든 지역변수 참조를 찾는다. 그것들을 새로 생성한 메서드의 지역변수나 매개변수로 사용할 것이다.
- 지역변수를 빼내기가 까다롭다면 뒤에 나오는 '임시변수 분리'나 '임시변수를 메서드 호출로 전환' 기법을 적용한다.
- 빼낸 코드에서 읽어들인 지역변수를 대상 메서드에 매개변수로 전달한다.
- 원본 메서드 안에 있는 빼낸 코드 부분을 새로 생성한 메서드 호출로 수정한다.

### 예제 소스코드
```java
class ...{
	private String _name;

	void printOwing() {
		Enumeration<E> e = _orders.elements();
		double outstanding = 0.0;
		
		// 배너 출력
		System.out.println("********************");
		System.out.println("****** 고객 외상 ******");
		System.out.println("********************");
		
		// 외상액 계산
		while(e.hasMoreElements()) {
			Order each = (Order)e.nextElement();
			outstanding += each.getAmount();
		}
		
		// 세부 내역 출력
		System.out.println("고객명 : " + _name);
		System.out.println("외상액: " + outstanding);
	}
}
```

### 예제 : 지역변수 사용 안 함
- 지역변수를 사용하지 않는 경우 간단하게 메서드로 추출하면 된다.
```java
	void printOwing() {
		// ...생략...

		// 배너 출력
		printBanner();
	}
	
	void printBanner() {
		System.out.println("********************");
		System.out.println("****** 고객 외상 ******");
		System.out.println("********************");
	}
```


### 예제 : 지역변수 사용
- 지역변수는 해당 메서드 안에서만 효력이 있으므로 메서드 추출을 적용하면 지역변수와 관련된 작업을 추가로 처리해야 한다.
  - 간혹 지역변수 때문에 리팩토링이 아예 불가능할 때도 있다.
- 처리하기 쉬운 지역변수는 읽히기만 하고 변경되지 않을 때다.
  - 이럴 땐 지역변수를 그냥 매개변수로 전달하면 된다.
- 지역변수가 객체이고 그 변수에 쓰기 메서드를 호출할 때도 마찬가지 방법을 사용한다.
```java
	void printOwing() {
		// ...생략...

		// 세부 내역 출력
		printDetails(outstanding);
	}
	
	void printDetails(double outstanding) {
		System.out.println("고객명 : " + _name);
		System.out.println("외상액: " + outstanding);
	}
```

### 예제 : 지역변수를 다시 대입
- 복잡한 경우는 지역변수로의 값 대입이다. 이럴 때는 임시변수만 생각하면 된다.
- 이후에 매개변수로 사용되는 변수가 있다면 이를 리턴하도록 한다.
```java
	void printOwing() {
		// 배너 출력
		printBanner();

		// 외상액 계산
		double outstanding = getOutstanding();
		
		// 세부 내역 출력
		printDetails(outstanding);
	}

	double getOutstanding() {
		Enumeration<E> e = _orders.elements();
		double outstanding = 0.0;
		
		while(e.hasMoreElements()) {
			Order each = (Order)e.nextElement();
			outstanding += each.getAmount();
		}
		
		return outstanding;
	}
```

# 임시변수를 메서드 호출로 전환
- 임시변수는 자신이 속한 메서드의 안에서만 인식되므로, 그 임시변수에 접근하려다 보면 코드는 길어지게 마련이다.
- 임시변수를 메서드 호출로 수정하면 클래스 안 모든 메서드가 그 정보에 접근할 수 있다.
- 해당 기법은 대부분의 경우 메서드 추출을 적용하기 전에 반드시 적용해야 한다.
  - 지역변수가 많을수록 메서드 추출이 힘들어지기 때문에

### 방법
- 값이 한 번만 대입되는 임시 변수를 찾는다.
- 그 임시변수를 final로 선언한다.
- 대입문 우변을 빼내어 메서드로 만든다.
  - 처음에는 private로 선언하고, 나중에 더 여러 곳에서 사용하게 되면 접근 제한을 간단히 완화한다.
  - 추출 메서드가 객체를 변경하진 않는지 확인한다. 만약 객체 변경 등의 문제가 있다면 상태 변경 메서드와 값 변환 메서드를 분리 기법(331쪽)을 실시한다.

### 예제 소스코드
```java
	double getPrice() {
		int basePrice = _quantity * _itemPrice;
		double discountFactor;
		if(basePrice > 1000) discountFactor = 0.95;
		else discountFactor = 0.98;
		return basePrice * discountFactor;
	}
```
- 임시변수를 final로 선언하고, 대입문 우변을 빼내어 메서드로 만든다.
```java
	double getPrice() {
		final int basePrice = basePrice();
		final double discountFactor;
		// ...생략...
	}
	
	private int basePrice() {
		return _quantity * _itemPrice;
	}
```
- 임시변수를 사용하던 부분을 메서드 호출로 바꾼다.
  - 이후에 basePrice 변수를 더 이상 사용하는 곳이 없어졌기 때문에 선언한 것을 삭제한다.
```java
	double getPrice() {
		//final int basePrice = basePrice();
		final double discountFactor;
		if(basePrice() > 1000) discountFactor = 0.95; // 함수로 호출
		else discountFactor = 0.98;
		return basePrice() * discountFactor; // 함수로 호출
	}
	
	private int basePrice() {
		return _quantity * _itemPrice;
	}
```
- 위의 방식을 반복해서 임시변수를 제거해 나간다.
  - basePrice 임시변수를 메서드 호출로 바꾸는게 가능했기 때문에 discountFactor도 메서드로 빼내기가 가능해졌다.
```
	double getPrice() {
		//final int basePrice = basePrice();
		//final double discountFactor;
		final double discountFactor = discountFactor();
		return basePrice() * discountFactor;
	}
	
	private int basePrice() {
		return _quantity * _itemPrice;
	}
	
	private double discountFactor() {
		if(basePrice() > 1000) return 0.95;
		else return 0.98;
	}
```

# 직관적 임시변수 사용
- 수식이 너무 복잡해져서 이해하기 힘들 때는 임시변수를 사용하여 수식을 더 처리하기 쉽게 쪼개도록 한다.
- 조건문에서 각 조건 절을 가져와서 직관적 이름의 임시변수를 사용해 그 조건의 의미를 설명하려 할 때 많이 사용한다.
- 해당 기법을 적용해야겠다는 생각이 들더라도 될 수 있으면 자제하고 대신에 메서드 추출을 사용할 수 있는지 생각해보고 노력한다.

### 방법
- 임시변수를 final로 선언하고, 복잡한 수식에서 한 부분의 결과를 그 임시변수에 대입한다.
- 그 수식에서 한 부분의 결과를 그 임시변수의 값으로 교체한다.
```java
if((platform.toUpperCase().indexOf("MAC") > -1) &&
	(browser.toUpperCase().indexOf("IE") > -1) &&
	wasInitialized() && resize > 0) { }

final boolean isMacOs = platform.toUpperCase().indexOf("MAC") > -1;
final boolean isIEBrowser = browser.toUpperCase().indexOf("IE") > -1;
final boolean wasResized = resize > 0

if(isMacOs && isIEBrowser && wasInitialized() && wasResized) { }

// 메서드 추출을 이용하면
boolean isMacOs(){
	return platform.toUpperCase().indexOf("MAC") > -1;
}
// ...생략...
```

# 임시변수 분리
- 임시변수는 긴 코드의 계산 결과를 나중에 간편히 참조할 수 있게 저장하는 용도로 사용된다.
- 이런 변수엔 값이 한 번만 대입되어야 한다.
- 여러 용도로 사용되는 변수는 각 용도별로 다른 변수를 사용하게 분리해야 한다.
- 임시변수 하나를 두 가지 용도로 사용하면 코드를 분석하는 사람에게 혼동을 줄 수 있기 때문이다.

### 방법
- 두 번 이상 대입되는 임시 변수들의 이름을 변경한다.
- 이름을 바꾼 새 임시변수를 final로 선언한다.

### 예제
```java
	double getDistanceTravelled(int time) {
		double result;
		double acc = primaryForce / mass;
		int secondaryTime = time - delay;
		if(secondaryTime > 0) {
			acc = primaryForce * secondaryForce / mass;
			result += primaryVel * secondaryTime + 0.5 * acc;
		}
		return result;
	}
```
- acc 변수에 값이 두 번 대입되는 것을 확인한다.
- 첫 번째 acc를 primaryAcc라고 이름을 바꾸고 final로 선언한다.
- 두 번째 acc는 secondaryAcc라고 이름을 바꾸고 final로 선언한다.

# 메서드를 메서드 객체로 전환
- 장황한 메서드에서 각 부분을 간결한 메서드로 빼내면 코드가 훨씬 이해하기 쉬워진다.
- 메서드 분해를 어렵게 만드는 것은 지역변수다.
- 앞에서 배운 '임시변수를 메서드 호출로 전환'을 적용하면 이런 어려움이 어느 정도 해소되지만, 분해가 필요한 메서드를 분해할 수 없을 때도 있다.
- 이럴 경우 '메서드를 메서드 객체로 전환' 기법을 적용하여 모든 지역변수를 메서드 객체의 속성으로 만들고, 그 객체에서 '메서드 추출'을 적용해 여러 개의 메서드로 쪼갠다.

### 방법
- 전환할 메서드의 이름과 같은 이름으로 새 클래스를 생성한다.
- 그 클래스에 원본 메서드가 들어 있던 객체를 나타내는 final 필드를 추가하고 원본 메서드 안의 각 임시변수와 매개변수에 해당하는 속성을 추가한다.
- 새 클래스에 원본 객체와 각 매개변수를 받는 생성자 메서드를 작성한다.
- 새 클레스에 compute라는 이름의 메서드를 작성한다.
- 원본 메서드 내용을 compute 메서드 안에 복사해 넣는다. 원본 객체에 있는 메서드를 호출할 땐 원본 객체를 나타내는 필드를 사용한다.
- 원본 메서드를 새 객체 생성과 compute 메서드 호출을 담당하는 메서드로 바꾼다.

### 예제 소스코드
```java
class Account
	int gamma(int inputVal, int quantity, int yearToDate) {
		int importantValue1 = (inputVal * quantity) + delta();
		int importantValue2 = (inputVal * yearToDate) + 100;
		if((yearToDate - importantValue1) > 100)
			importantValue2 -= 20;
		int importantValue3 = importantValue2 * 7;
		return importantValue3 - 2*importantValue1;
	}
```
- gamma 메서드를 새 클래스로 선언하고, 원본 객체를 나타내는 final 필드를 작성하고, 원본 메서드 안의 각 매개변수와 임시변수를 나타내는 필드를 작성한다.
```java
class Gamma{
	private final Account _account;
	private int inputVal;
	private int quantity;
	private int yearToDate;
	private int importantValue1;
	private int importantValue2;
	private int importantValue3;
```
- 원본 메서드의 매개변들을 생성자 메서드를 추가한다.
```java
Gamma(Account source, int inputVal, int quantity, int yearToDate){
	this._account = source;
	this.inputVal = inputVal;
	this.quantity = quantity;
	this.yearToDate = yearToDate
}
```
- compute 메서드를 만들고 여기에 원본 메서드를 옮긴다.
```java
int compute(){
	int importantValue1 = (inputVal * quantity) + _account.delta();
	int importantValue2 = (inputVal * yearToDate) + 100;
	if((yearToDate - importantValue1) > 100)
		importantValue2 -= 20;
	int importantValue3 = importantValue2 * 7;
	return importantValue3 - 2*importantValue1;
}

```
- 원본 메서드가 이 메서드 객체로 위임하게 다음과 같이 수정한다.
```
	int gamma(int inputVal, int quantity, int yearToDate) {
		return new Gamma(this, inputVal, quantity, yearToDate).compute();
	}
```
- 이러한 리팩토링 작업을 통해 인자를 전달할 걱정 없이 compute 메서드에서 손쉽게 메서드 추출 기법을 실시할 수 있다.
  - 기존의 compute 메서드에서 if 절에 대해 메서드 추출을 실시
```java
int compute(){
	int importantValue1 = (inputVal * quantity) + _account.delta();
	int importantValue2 = (inputVal * yearToDate) + 100;

	importantThing(); // 메서드 추출 실시

	int importantValue3 = importantValue2 * 7;
	return importantValue3 - 2*importantValue1;
}

void importantThing(){
	if((yearToDate - importantValue1) > 100)
		importantValue2 -= 20;
}
```

# 알고리즘 전환
- 어떤 기능을 수행하기 위한 비교적 간단한 방법이 있다면 복잡한 방법을 좀 더 간단한 방법으로 교체한다.
- 간혹 알고리즘을 전부 삭제하고 더 간단한 알고리즘으로 교체해야 할 수도 있다.
- 알고리즘을 교체했을 때 기존의 결과와 같은 결과가 나오는지 여러번 테스트를 실시한다.
- 기존 소스코드
```java
	String foundPerson(String[] people) {
		for(int i=0; i<people.length; i++) {
			if(people[i].equals("Don"))
				return "Don";
			if(people[i].equals("John"))
				return "John";
			if(people[i].equals("Kent"))
				return "Kent";
		}
		return "";
	}
```
- 간단하게 변경한 소스코드
```java
	String foundPerson(String[] people) {
		List candidates = Arrays.asList(new String[] {"Don", "John", "Kent"});
		for(int i=0; i<people.length; i++) {
			if(candidates.contains(people[i]))
				return people[i];
		}
		return "";
	}
```