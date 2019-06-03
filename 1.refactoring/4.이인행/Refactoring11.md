# �ʵ� ����

### ����
- ������ ����Ŭ������ ���� ���� ���̰ų� �����丵�� �����ؼ� ������ ���, ���� ����Ŭ������ �ߺ��� ����� ��� �ִ� ��찡 ����.
- �ߺ��� �ʵ尡 ���� ����� ������� ���ȴٸ� �� �ʵ带 ����Ŭ������ �ű�� �۾��� �Ѵ�.
- �ش� ������� ���� ������ ������ �ߺ��� ��������, �� �ʵ带 ����ϴ� ����� ����Ŭ�������� ����Ŭ������ �Ű�����.

### ���
- ����Ŭ������ �ű� �ʵ尡 ���� ��� �κ��� �˻��ؼ� ���� ������� ���Ǵ��� Ȯ���Ѵ�.
- �ʵ���� �̸��� ���� �ʴٸ� �ʵ���� ����Ŭ���� �ʵ�� ����� �̸����� �����Ѵ�.
- ���� Ŭ���� �ȿ� �� �ʵ带 �ۼ��Ѵ�.
- ���� Ŭ������ �ʵ带 �����Ѵ�.

### ����
- Salesman Ŭ����
```java
public class Salesman {

	private String name;
	private String address;
	private String salary;
	private String account;
}
```
- Engineer Ŭ����
```java
public class Engineer {

	private String name;
	private String address;
	private String salary;
	private String skill;
}
```
- name, address, salary�� �ʵ尡 �����Ƿ� ���� Ŭ������ �ű��.
  - Salesman�� Engineer�� �ƿ츣�� Employee Ŭ������ ���� Ŭ������ �ۼ��Ѵ�.
```java
public class Employee {

	protected String name;
	protected String address;
	protected String salary;
}
```

# �޼��� ����

### ����
- �޼����� ������ ��ġ �����ؼ� �ٿ� ���� ��ó�� ���� ���� �� �ǽ��Ѵ�.
- �� �޼����� ������ ���� ����ϴٸ� ���̰� ���� �κ��� ã�Ƽ� �ϳ��� �޼���� ���� �� ������ ����غ���.
- ����Ŭ���� �޼��尡 ����Ŭ���� �޼��带 �������Կ��� �ұ��ϰ� ����� ���� �� �ǽ��Ѵ�.

### ���
- �޼��尡 ���� ������ �˻��Ѵ�.
- �޼������ ���� �ٸ��� ���� Ŭ�������� ��� ���� Ŭ������ �޼���� ��︮�� �̸����� �޼������ �����Ѵ�.
- ����Ŭ���� �ȿ� �� �޼��带 �ۼ��ϰ� �� �޼��� �ȿ� ���� �޼����� ������ ������ �� ������ �����Ѵ�.
  - �޼��帶�� ����Ǵ� �κа� ���̰� ���� �κ��� ������ ���캻��.
  - ����Ŭ�������� �ְ� ����Ŭ�������� ���� �ٸ� �޼��带 ȣ���Ѵٸ� ����Ŭ������ abstract Ÿ���� �޼��带 �����Ѵ�.
- ����Ŭ������ �޼��带 �����Ѵ�.

### ����
```java
void createBill(Date date){
	double chargeAmount = chargeFor(date);
	addBill(date);
}
```
- createBill �޼��尡 �� Ŭ�������� ���� ���̶�� ���� ���.
- �ش� ���ÿ��� chargeFor �޼��� �κи� �ٸ��� �����Ѵ�.
- �̷� ��� �ٸ��� �����ϴ� chargeFor �޼��常 ����Ŭ�������� abstract�� �����ϰ�, createBill �޼���� ����Ŭ������ ����.
- ���� Ŭ����
```java
public abstract class ����Ŭ����{
	protected abstract double chargeFor(Date date);
	protected void createBill(Date date){ ... }
```
- ���� Ŭ����
```java
public class ����Ŭ����1{
	@Override
	private double chargeFor(Date date) { }
}
```
- ���� Ŭ����
```java
public class ����Ŭ����2{
	@Override
	private double chargeFor(Date date){ }
}
```

# ������ ���� ����

### ����
- ����Ŭ������ ��ü�� �������� ����� ���� ����̴�.
- �̷� �� ����Ŭ�������� ������ �޼��带 �ۼ��ϰ� ����Ŭ������ �÷��� ����Ŭ������ ȣ���ϰ� �Ѵ�.
- �����ڴ� ����� �Ұ����ϱ� ������ �޼���� ��ȯ ����� �����ؾ� �� ���� �ִ�.

### ���
- ����Ŭ������ �����ڸ� �����Ѵ�.
- ����Ŭ���� �����ڿ��� �� �κ��� �������� �ڵ带 ����Ŭ���� ������ ������ �ű��.
- ����Ŭ���� ������ ���� �� �տ� ����Ŭ���� ������ ȣ�� �ڵ带 �ִ´�.

### ����
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
		if (isPriviliged()) assignCar(); // ��� ����Ŭ������ ���� ���
	}
}
```
- name�� id�� �����ϴ� �κ��� �����Ƿ� ����Ŭ������ Manager���� ����Ŭ������ Employee�� �����ڸ� ȣ���Ѵ�.
- ���� ���ǹ� �˻� �� assignCar() �޼��带 ȣ���ϴ� �κ��� ��� ����Ŭ������ ���� ��� ������, grade ������ ���� �� ����Ǿ�� �ϹǷ� �޼��� ����� �޼��� ������ �����Ѵ�.
```java
public class Employee{
	public Employee(String name, String id){
		this.name = name;
		this.id = id;
	}

	protected void initialize(){
		if (isPriviliged()) assignCar(); // ��� ����Ŭ������ ���� ���
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

# Ŭ���� ����

### ����
- Ŭ������ Ȯ���ϰ� �߻�ȭ�Ǿ�� �ϸ�, �μ� ������ ��Ȯ�� ����� ����ؾ� �Ѵ�.
- Ŭ������ �ʹ� ����ϴٸ� �����ͳ� �޼��带 �ϳ� �����ϸ� ��� ����, �ٸ� �ʵ�� �޼��带 �߰��ϴ� �� �ո������� ������ �ڹ��غ���.
- �� Ŭ������ ó���ؾ� �� ����� �ϳ��� Ŭ������ ��� ���� �� �� Ŭ������ ����� ���� Ŭ������ ���� �ʵ�� �޼��带 �� Ŭ������ �ű⵵�� �Ѵ�.

### ���
- Ŭ������ ��� �и� ����� ���ϰ�, �и��� ����� ���� �� Ŭ������ �ۼ��Ѵ�.
- ���� Ŭ�������� �� Ŭ�������� ��ũ�� �����.
- �ű� �ʵ帶�� �ʵ� �̵��� �����Ѵ�.
- �޼��� �̵��� �ǽ��ؼ� ���� Ŭ������ �޼��带 �� Ŭ������ �ű��.

### ����
- Person Ŭ������ �ʹ� ����ϴٰ� �����ϸ�, ��ȭ��ȣ ����� �ϳ��� Ŭ������ ���� ������ �Ѵ�.
```java
public class Person {
	public String getName() { }
	public String getTelephoneNumber() { } // ��ȭ��ȣ ��� �޼���
	public String getOfficeAreaCode() { }  // ��ȭ��ȣ ��� �޼���
}
```
- TelephoneNumber Ŭ������ �����, Person Ŭ������ �ش� Ŭ������ ��ũ�� �����Ѵ�.
```java
public class TelephoneNumber{
	public String getNumber() { } // ��ȭ��ȣ ��� �޼���
	public String getAreaCode() { }  // ��ȭ��ȣ ��� �޼���
}

public class Person
	private TelephoneNumber tn = new TelephoneNumber();
```
- Person Ŭ�������� ��ȭ��ȣ ����� ����ϴ� �κ��� �־��ٸ� ��ũ�� ����� �ش� �޼��带 ȣ���ϵ��� �Ѵ�.
