# 개요 

feature를 가리지 않고 자주 사용되는 공통적인 작업이 있을때, Interceptor, AOP와 함께 CustomTag를 활용 할 수 있다. 

JSP에서 커스텀태그를 사용하는것 만으로 백단 코드 작성 없이 백단의 로직까지 실행시킬 수 있음. 

주로 헤더, 푸터, 메뉴 등 기능 안가리고 들어가는곳에 동적인 기능이 존재 할 때 커스텀태그를 활용할 수 있음. 예를 들면 메뉴를 동적으로 출력할때 모든 기능 백단에 메뉴 List를 가져오는 코드를 작성하는 대신, JSP 한곳에 커스텀태그로 메뉴 List를 가져오는걸로 대체 할 수 있음.



# 절차

1. TagSupport 상속 클래스 작성
2. tld 작성
3. web.xml에 tld 등록
4. JSP에서 활용



# 클래스 작성

![](.\2020-10-18 18 01 40.png)

- TagSupport를 상속받고 doStartTag()를 오버라이드 한다.

- pageContext.setAttribute("key",value)를 통해 결과값을 반환할 수 있다.

- parameter로 사용할 값을 멤버변수로 작성하고 setter메소드를 작성한다.

- 그 외에는 하단 참고코드 참조

![](.\참고\2020-10-15_14_51_32.png)

# tld 작성

![2020-10-18 18 01 50](.\2020-10-18 18 01 50.png)

![2020-10-18 18 01 56](.\2020-10-18 18 01 56.png)

![2020-10-18 18 02 00](.\2020-10-18 18 02 00.png)

![2020-10-18 18 02 12](.\2020-10-18 18 02 12.png)

![2020-10-18 18 02 17](.\2020-10-18 18 02 17.png)

![2020-10-18 18 02 22](.\2020-10-18 18 02 22.png)

- xml파일을 생성한다. 이때 파일명을 작성할때 확장자를 tld로 변경하여 생성해준다

- taglib>tlib-version, jsp-version, short-name, uri, tag>name, tag-class, body-content, attribute> name, required 구성의 태그를 작성해준다

- ```xml
  <taglib>
    <tlib-version>1.0</tlib-version>
    <jsp-version>1.2</jsp-version>
    <short-name>mytag</short-name>
    <uri>http://localhost/jsp/tlds/mytag</uri>
    <tag>
      <name>test</name>
      <tag-class>com.domain.customtag.MyTag</tag-class>
      <body-content>whatisthis</body-content>
      <attribute>
      	<name>
      		param
      	</name>
      	<required>
      		true
      	</required>
      </attribute>
      <attribute>    	
      	<name>
      		result
      	</name>
      	<required>
      		true
      	</required>
      </attribute>
    </tag>
  </taglib>
  
  ```



# web.xml 수정

![](.\2020-10-18 18 02 27.png)

- web.xml에 tld경로를 잡아준다. /WEB-INF 하위에 바로 있을시엔 안해줘도 된다는데 그건 디렉토리 구조상 별로

```xml
	<jsp-config>
		<taglib>
			<taglib-uri>
				http://localhost/jsp/tlds/mytag
			</taglib-uri>
			<taglib-location>
				/WEB-INF/tld/MyTag.tld
			</taglib-location>
		</taglib>
	</jsp-config>
```







# JSP에서의 사용

![](.\2020-10-18 18 02 30.png)

- taglib을 작성한뒤 사용한다.

