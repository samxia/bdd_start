����Cucumber+Selenium��Gclub��¼���ܵ��Զ���������ʾ��

<h1>���÷���</h1>
��windows7�µ���ͨ��
<h2>1.���firefox������İ汾��Firefox>=60 </h2>
<h2>1.����selenium ����firefox�����������</h2>
���ص�ַ��<a href="https://github.com/mozilla/geckodriver/releases">https://github.com/mozilla/geckodriver/releases</a>
���ڴ�ҳ��������.zip��,����OS��Ӧ�汾
<h3>�����꣬����Ŀ¼��C:\WebDriver\bin���£���Ŀ¼�ɸ��ģ���������ʱͨ��java����ָ����Ҳ��ͨ��mvn����,Ҳ�����û�������������ʾhardcode��</h3>
������ο���<a href="https://www.selenium.dev/documentation/en/selenium_installation/installing_webdriver_binaries/">
https://www.selenium.dev/documentation/en/selenium_installation/installing_webdriver_binaries/</a><P>
����Ҫ��װ���벻Ҫ����������ʱjava�����



<h1>ʹ�÷���</h1>
$git clone ....
<h3>@smoke tag ��Ӧ����������ȷ���û���������Ĳ�������</h3>
$ mvn test -Dcucumber.filter.tags="@smoke"

<h3>@login tag ��Ӧ����ִ������login feature�Ĳ�������</h3>
$ mvn test -Dcucumber.filter.tags="@login"

<p>������</p>


������ѧϰcucumberʱ����ϰ��������
-----------------------------------------------------------------
$mvn test -Dcucumber.filter.tags="@add_to_cart"
<br>to run cart relative feature
<br>
$mvn test -Dcucumber.filter.tags="@friday"
<br>
to run is_it_friday.feature

$mvn test -Dcucumber.filter.tags="@add_to_cart or @friday"
<br>to run both

To show cucumber works

Need to learn:
 <br>custom Cucumber reporting plugin

