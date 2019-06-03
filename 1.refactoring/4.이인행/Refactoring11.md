# 필드 상향

### 동기
- 각각의 하위클래스를 따로 개발 중이거나 리팩토링을 적용해서 연결할 경우, 여러 하위클래스에 중복된 기능이 들어 있는 경우가 많다.
- 중복된 필드가 서로 비슷한 방식으로 사용된다면 그 필드를 상위클래스로 옮기는 작업을 한다.
- 해당 방법으로 인해 데이터 선언의 중복이 없어지고, 그 필드를 사용하는 기능이 하위클래스에서 상위클래스로 옮겨진다.

### 방법
- 상위클래스로 옮길 필드가 사용된 모든 부분을 검사해서 같은 방식으로 사용되는지 확인한다.
- 필드들의 이름이 같지 않다면 필드명을 상위클래스 필드로 사용할 이름으로 변경한다.
- 상위 클래스 안에 새 필드를 작성한다.
- 하위 클래스의 필드를 삭제한다.

### 예시
- Salesman 클래스
```java
public class Salesman {

	private String name;
	private String address;
	private String salary;
	private String account;
}
```
- Engineer 클래스
```java
public class Engineer {

	private String name;
	private String address;
	private String salary;
	private String skill;
}
```
- name, address, salary의 필드가 같으므로 상위 클래스로 옮긴다.
  - Salesman과 Engineer를 아우르는 Employee 클래스를 상위 클래스로 작성한다.
```java
public class Employee {

	protected String name;
	protected String address;
	protected String salary;
}
```

# 메서드 상향

### 동기
- 메서드의 내용이 마치 복사해서 붙여 넣은 것처럼 서로 같을 때 실시한다.
- 두 메서드의 동작이 거의 비슷하다면 차이가 나는 부분을 찾아서 하나의 메서드로 만들 수 없는지 고민해본다.
- 하위클래스 메서드가 상위클래스 메서드를 재정의함에도 불구하고 기능이 같을 때 실시한다.

### 방법
- 메서드가 서로 같은지 검사한다.
- 메서드명이 서로 다르면 상위 클래스에서 모든 하위 클래스의 메서드로 어울리는 이름으로 메서드명을 수정한다.
- 상위클래스 안에 새 메서드를 작성하고 새 메서드 안에 같은 메서드의 내용을 복사한 후 적절히 수정한다.
  - 메서드마다 공통되는 부분과 차이가 나는 부분을 유심히 살펴본다.
  - 하위클래스에는 있고 상위클래스에는 없는 다른 메서드를 호출한다면 상위클래스에 abstract 타입의 메서드를 선언한다.
- 하위클래스의 메서드를 삭제한다.

### 예시
```java
void createBill(Date date){
	double chargeAmount = chargeFor(date);
	addBill(date);
}
```
- createBill 메서드가 두 클래스에서 공통 적이라고 예를 든다.
- 해당 예시에서 chargeFor 메서드 부분만 다르게 동작한다.
- 이럴 경우 다르게 동작하는 chargeFor 메서드만 상위클래스에서 abstract로 선언하고, createBill 메서드는 상위클래스로 뺀다.
- 상위 클래스
```java
public abstract class 상위클래스{
	protected abstract double chargeFor(Date date);
	protected void createBill(Date date){ ... }
```
- 하위 클래스
```java
public class 하위클래스1{
	@Override
	private double chargeFor(Date date) { }
}
```
- 하위 클래스
```java
public class 하위클래스2{
	@Override
	private double chargeFor(Date date){ }
}
```

# 생성자 내용 상향

### 동기
- 하위클래스는 대체로 공통적인 기능이 생성 기능이다.
- 이럴 땐 하위클래스에서 생성자 메서드를 작성하고 상위클래스로 올려서 하위클랫들이 호출하게 한다.
- 생성자는 상속이 불가능하기 때문에 메서드로 전환 기법을 적용해야 할 수도 있다.

### 방법
- 상위클래스에 생성자를 정의한다.
- 하위클래스 생성자에서 앞 부분의 공통적인 코드를 상위클래스 생성자 안으로 옮긴다.
- 하위클래스 생성자 안의 맨 앞에 상위클래스 생성자 호출 코드를 넣는다.

### 예제
```java
public class Employee{
	public Employee(String name, String id){
		this.name = name;
		this.id = id;
	}

public class Manager extends Employee {
	public Manager(String name, String id, int grade){
		this.name = name;
		this.id = id;
		this.grade = grade;
		if (isPriviliged()) assignCar(); // 모든 하위클래스의 공통 기능
	}
}
```
- name과 id를 주입하는 부분이 같으므로 하위클래스인 Manager에서 상위클래스인 Employee의 생성자를 호출한다.
- 또한 조건문 검사 후 assignCar() 메서드를 호출하는 부분은 모든 하위클래스의 공통 기능 이지만, grade 주입이 끝난 후 실행되어야 하므로 메서드 추출과 메서드 상향을 적용한다.
```java
public class Employee{
	public Employee(String name, String id){
		this.name = name;
		this.id = id;
	}

	protected void initialize(){
		if (isPriviliged()) assignCar(); // 모든 하위클래스의 공통 기능
	}
}

public class Manager extends Employee {
	public Manager(String name, String id, int grade){
		super(name, id);
		this.grade = grade;
		initialize();
	}
}
```

# 클래스 추출

### 동기
- 클래스는 확실하게 추상화되어야 하며, 두세 가지의 명확한 기능을 담당해야 한다.
- 클래스가 너무 방대하다면 데이터나 메서드를 하나 제거하면 어떻게 될지, 다른 필드와 메서드를 추가하는 건 합리적이지 않은지 자문해본다.
- 두 클래스가 처리해야 할 기능이 하나의 클래스에 들어 있을 땐 새 클레스를 만들고 기존 클래스의 관련 필드와 메서드를 새 클래스로 옮기도록 한다.

### 방법
- 클래스의 기능 분리 방법을 정하고, 분리한 기능을 넣을 새 클래스를 작성한다.
- 원본 클래스에서 새 클래스로의 링크를 만든다.
- 옮길 필드마다 필드 이동을 적용한다.
- 메서드 이동을 실시해서 원본 클래스의 메서드를 새 클래스로 옮긴다.

### 예제
- Person 클래스가 너무 방대하다고 가정하면, 전화번호 기능을 하나의 클래스로 떼어 내도록 한다.
```java
public class Person {
	public String getName() { }
	public String getTelephoneNumber() { } // 전화번호 기능 메서드
	public String getOfficeAreaCode() { }  // 전화번호 기능 메서드
}
```
- TelephoneNumber 클래스를 만들고, Person 클래스는 해당 클래스를 링크로 연결한다.
```java
public class TelephoneNumber{
	public String getNumber() { } // 전화번호 기능 메서드
	public String getAreaCode() { }  // 전화번호 기능 메서드
}

public class Person
	private TelephoneNumber tn = new TelephoneNumber();
```
- Person 클래스에서 전화번호 기능을 사용하는 부분이 있었다면 링크를 사용해 해당 메서드를 호출하도록 한다.
