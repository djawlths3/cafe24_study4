# �޼��� ����
- �޼��忡�� ���� ��� �������� ��Ȳ�� �޼���� ���� �����.
- ��Ȳ�� �޼��忡�� ���� ������ ��� �ִµ�, ���� ���� ������ ������ �� �������� ����������.
- � �ڵ带 �׷����� ��� �ǰڴٰ� �Ǵܵ� �� �� �ڵ带 ������ ������ �� ��Ÿ���� ������ �̸��� �޼���� ���鵵�� �Ѵ�.
- �޼��尡 �ʹ� ��ų� �ڵ忡 �ּ��� �޾ƾ߸� �ǵ��� ������ �� ���� ��, �� �ڵ带 ������ ������ �޼���� �����.
- �������� �̸��� ������ �޼��尡 ���� ������ ������ ����.
  - �޼��尡 ������ �߰� �ɰ��� ������ �ٸ� �޼��忡�� ���� ����� �� �ִ�.
  - ���� ������ �޼��忡�� �ּ� ���� �� ���� ������ �о���� �� �ִ�.
  - �������ϱ⵵ �ξ� �����ϴ�.

### ���
- ������ �����ϴ� �̸��� �� �޼��带 �����Ѵ�. �̶� �޼������ ������ �ƴ϶� ����� ��Ÿ���� �̸��̾�� �Ѵ�.
- ���� �޼��忡�� ���� �ڵ带 ���� ������ �޼���� �����Ѵ�.
- ���� �ڵ忡�� ���� �޼����� ��� �������� ������ ã�´�. �װ͵��� ���� ������ �޼����� ���������� �Ű������� ����� ���̴�.
- ���������� �����Ⱑ ��ٷӴٸ� �ڿ� ������ '�ӽú��� �и�'�� '�ӽú����� �޼��� ȣ��� ��ȯ' ����� �����Ѵ�.
- ���� �ڵ忡�� �о���� ���������� ��� �޼��忡 �Ű������� �����Ѵ�.
- ���� �޼��� �ȿ� �ִ� ���� �ڵ� �κ��� ���� ������ �޼��� ȣ��� �����Ѵ�.

### ���� �ҽ��ڵ�
```java
class ...{
	private String _name;

	void printOwing() {
		Enumeration<E> e = _orders.elements();
		double outstanding = 0.0;
		
		// ��� ���
		System.out.println("********************");
		System.out.println("****** �� �ܻ� ******");
		System.out.println("********************");
		
		// �ܻ�� ���
		while(e.hasMoreElements()) {
			Order each = (Order)e.nextElement();
			outstanding += each.getAmount();
		}
		
		// ���� ���� ���
		System.out.println("���� : " + _name);
		System.out.println("�ܻ��: " + outstanding);
	}
}
```

### ���� : �������� ��� �� ��
- ���������� ������� �ʴ� ��� �����ϰ� �޼���� �����ϸ� �ȴ�.
```java
	void printOwing() {
		// ...����...

		// ��� ���
		printBanner();
	}
	
	void printBanner() {
		System.out.println("********************");
		System.out.println("****** �� �ܻ� ******");
		System.out.println("********************");
	}
```


### ���� : �������� ���
- ���������� �ش� �޼��� �ȿ����� ȿ���� �����Ƿ� �޼��� ������ �����ϸ� ���������� ���õ� �۾��� �߰��� ó���ؾ� �Ѵ�.
  - ��Ȥ �������� ������ �����丵�� �ƿ� �Ұ����� ���� �ִ�.
- ó���ϱ� ���� ���������� �����⸸ �ϰ� ������� ���� ����.
  - �̷� �� ���������� �׳� �Ű������� �����ϸ� �ȴ�.
- ���������� ��ü�̰� �� ������ ���� �޼��带 ȣ���� ���� �������� ����� ����Ѵ�.
```java
	void printOwing() {
		// ...����...

		// ���� ���� ���
		printDetails(outstanding);
	}
	
	void printDetails(double outstanding) {
		System.out.println("���� : " + _name);
		System.out.println("�ܻ��: " + outstanding);
	}
```

### ���� : ���������� �ٽ� ����
- ������ ���� ������������ �� �����̴�. �̷� ���� �ӽú����� �����ϸ� �ȴ�.
- ���Ŀ� �Ű������� ���Ǵ� ������ �ִٸ� �̸� �����ϵ��� �Ѵ�.
```java
	void printOwing() {
		// ��� ���
		printBanner();

		// �ܻ�� ���
		double outstanding = getOutstanding();
		
		// ���� ���� ���
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

# �ӽú����� �޼��� ȣ��� ��ȯ
- �ӽú����� �ڽ��� ���� �޼����� �ȿ����� �νĵǹǷ�, �� �ӽú����� �����Ϸ��� ���� �ڵ�� ������� �����̴�.
- �ӽú����� �޼��� ȣ��� �����ϸ� Ŭ���� �� ��� �޼��尡 �� ������ ������ �� �ִ�.
- �ش� ����� ��κ��� ��� �޼��� ������ �����ϱ� ���� �ݵ�� �����ؾ� �Ѵ�.
  - ���������� �������� �޼��� ������ ��������� ������

### ���
- ���� �� ���� ���ԵǴ� �ӽ� ������ ã�´�.
- �� �ӽú����� final�� �����Ѵ�.
- ���Թ� �캯�� ������ �޼���� �����.
  - ó������ private�� �����ϰ�, ���߿� �� ���� ������ ����ϰ� �Ǹ� ���� ������ ������ ��ȭ�Ѵ�.
  - ���� �޼��尡 ��ü�� �������� �ʴ��� Ȯ���Ѵ�. ���� ��ü ���� ���� ������ �ִٸ� ���� ���� �޼���� �� ��ȯ �޼��带 �и� ���(331��)�� �ǽ��Ѵ�.

### ���� �ҽ��ڵ�
```java
	double getPrice() {
		int basePrice = _quantity * _itemPrice;
		double discountFactor;
		if(basePrice > 1000) discountFactor = 0.95;
		else discountFactor = 0.98;
		return basePrice * discountFactor;
	}
```
- �ӽú����� final�� �����ϰ�, ���Թ� �캯�� ������ �޼���� �����.
```java
	double getPrice() {
		final int basePrice = basePrice();
		final double discountFactor;
		// ...����...
	}
	
	private int basePrice() {
		return _quantity * _itemPrice;
	}
```
- �ӽú����� ����ϴ� �κ��� �޼��� ȣ��� �ٲ۴�.
  - ���Ŀ� basePrice ������ �� �̻� ����ϴ� ���� �������� ������ ������ ���� �����Ѵ�.
```java
	double getPrice() {
		//final int basePrice = basePrice();
		final double discountFactor;
		if(basePrice() > 1000) discountFactor = 0.95; // �Լ��� ȣ��
		else discountFactor = 0.98;
		return basePrice() * discountFactor; // �Լ��� ȣ��
	}
	
	private int basePrice() {
		return _quantity * _itemPrice;
	}
```
- ���� ����� �ݺ��ؼ� �ӽú����� ������ ������.
  - basePrice �ӽú����� �޼��� ȣ��� �ٲٴ°� �����߱� ������ discountFactor�� �޼���� �����Ⱑ ����������.
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

# ������ �ӽú��� ���
- ������ �ʹ� ���������� �����ϱ� ���� ���� �ӽú����� ����Ͽ� ������ �� ó���ϱ� ���� �ɰ����� �Ѵ�.
- ���ǹ����� �� ���� ���� �����ͼ� ������ �̸��� �ӽú����� ����� �� ������ �ǹ̸� �����Ϸ� �� �� ���� ����Ѵ�.
- �ش� ����� �����ؾ߰ڴٴ� ������ ����� �� �� ������ �����ϰ� ��ſ� �޼��� ������ ����� �� �ִ��� �����غ��� ����Ѵ�.

### ���
- �ӽú����� final�� �����ϰ�, ������ ���Ŀ��� �� �κ��� ����� �� �ӽú����� �����Ѵ�.
- �� ���Ŀ��� �� �κ��� ����� �� �ӽú����� ������ ��ü�Ѵ�.
```java
if((platform.toUpperCase().indexOf("MAC") > -1) &&
	(browser.toUpperCase().indexOf("IE") > -1) &&
	wasInitialized() && resize > 0) { }

final boolean isMacOs = platform.toUpperCase().indexOf("MAC") > -1;
final boolean isIEBrowser = browser.toUpperCase().indexOf("IE") > -1;
final boolean wasResized = resize > 0

if(isMacOs && isIEBrowser && wasInitialized() && wasResized) { }

// �޼��� ������ �̿��ϸ�
boolean isMacOs(){
	return platform.toUpperCase().indexOf("MAC") > -1;
}
// ...����...
```

# �ӽú��� �и�
- �ӽú����� �� �ڵ��� ��� ����� ���߿� ������ ������ �� �ְ� �����ϴ� �뵵�� ���ȴ�.
- �̷� ������ ���� �� ���� ���ԵǾ�� �Ѵ�.
- ���� �뵵�� ���Ǵ� ������ �� �뵵���� �ٸ� ������ ����ϰ� �и��ؾ� �Ѵ�.
- �ӽú��� �ϳ��� �� ���� �뵵�� ����ϸ� �ڵ带 �м��ϴ� ������� ȥ���� �� �� �ֱ� �����̴�.

### ���
- �� �� �̻� ���ԵǴ� �ӽ� �������� �̸��� �����Ѵ�.
- �̸��� �ٲ� �� �ӽú����� final�� �����Ѵ�.

### ����
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
- acc ������ ���� �� �� ���ԵǴ� ���� Ȯ���Ѵ�.
- ù ��° acc�� primaryAcc��� �̸��� �ٲٰ� final�� �����Ѵ�.
- �� ��° acc�� secondaryAcc��� �̸��� �ٲٰ� final�� �����Ѵ�.

# �޼��带 �޼��� ��ü�� ��ȯ
- ��Ȳ�� �޼��忡�� �� �κ��� ������ �޼���� ������ �ڵ尡 �ξ� �����ϱ� ��������.
- �޼��� ���ظ� ��ư� ����� ���� ����������.
- �տ��� ��� '�ӽú����� �޼��� ȣ��� ��ȯ'�� �����ϸ� �̷� ������� ��� ���� �ؼҵ�����, ���ذ� �ʿ��� �޼��带 ������ �� ���� ���� �ִ�.
- �̷� ��� '�޼��带 �޼��� ��ü�� ��ȯ' ����� �����Ͽ� ��� ���������� �޼��� ��ü�� �Ӽ����� �����, �� ��ü���� '�޼��� ����'�� ������ ���� ���� �޼���� �ɰ���.

### ���
- ��ȯ�� �޼����� �̸��� ���� �̸����� �� Ŭ������ �����Ѵ�.
- �� Ŭ������ ���� �޼��尡 ��� �ִ� ��ü�� ��Ÿ���� final �ʵ带 �߰��ϰ� ���� �޼��� ���� �� �ӽú����� �Ű������� �ش��ϴ� �Ӽ��� �߰��Ѵ�.
- �� Ŭ������ ���� ��ü�� �� �Ű������� �޴� ������ �޼��带 �ۼ��Ѵ�.
- �� Ŭ������ compute��� �̸��� �޼��带 �ۼ��Ѵ�.
- ���� �޼��� ������ compute �޼��� �ȿ� ������ �ִ´�. ���� ��ü�� �ִ� �޼��带 ȣ���� �� ���� ��ü�� ��Ÿ���� �ʵ带 ����Ѵ�.
- ���� �޼��带 �� ��ü ������ compute �޼��� ȣ���� ����ϴ� �޼���� �ٲ۴�.

### ���� �ҽ��ڵ�
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
- gamma �޼��带 �� Ŭ������ �����ϰ�, ���� ��ü�� ��Ÿ���� final �ʵ带 �ۼ��ϰ�, ���� �޼��� ���� �� �Ű������� �ӽú����� ��Ÿ���� �ʵ带 �ۼ��Ѵ�.
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
- ���� �޼����� �Ű������� ������ �޼��带 �߰��Ѵ�.
```java
Gamma(Account source, int inputVal, int quantity, int yearToDate){
	this._account = source;
	this.inputVal = inputVal;
	this.quantity = quantity;
	this.yearToDate = yearToDate
}
```
- compute �޼��带 ����� ���⿡ ���� �޼��带 �ű��.
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
- ���� �޼��尡 �� �޼��� ��ü�� �����ϰ� ������ ���� �����Ѵ�.
```
	int gamma(int inputVal, int quantity, int yearToDate) {
		return new Gamma(this, inputVal, quantity, yearToDate).compute();
	}
```
- �̷��� �����丵 �۾��� ���� ���ڸ� ������ ���� ���� compute �޼��忡�� �ս��� �޼��� ���� ����� �ǽ��� �� �ִ�.
  - ������ compute �޼��忡�� if ���� ���� �޼��� ������ �ǽ�
```java
int compute(){
	int importantValue1 = (inputVal * quantity) + _account.delta();
	int importantValue2 = (inputVal * yearToDate) + 100;

	importantThing(); // �޼��� ���� �ǽ�

	int importantValue3 = importantValue2 * 7;
	return importantValue3 - 2*importantValue1;
}

void importantThing(){
	if((yearToDate - importantValue1) > 100)
		importantValue2 -= 20;
}
```

# �˰��� ��ȯ
- � ����� �����ϱ� ���� ���� ������ ����� �ִٸ� ������ ����� �� �� ������ ������� ��ü�Ѵ�.
- ��Ȥ �˰����� ���� �����ϰ� �� ������ �˰������� ��ü�ؾ� �� ���� �ִ�.
- �˰����� ��ü���� �� ������ ����� ���� ����� �������� ������ �׽�Ʈ�� �ǽ��Ѵ�.
- ���� �ҽ��ڵ�
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
- �����ϰ� ������ �ҽ��ڵ�
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