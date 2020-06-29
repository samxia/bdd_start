这是Cucumber+Selenium在Gclub登录功能的自动化测试演示：

<h1>配置方法</h1>
在windows7下调试通过
<h2>1.检查firefox浏览器的版本，Firefox>=60 </h2>
<h2>1.下载selenium 调用firefox浏览器的驱动</h2>
下载地址：<a href="https://github.com/mozilla/geckodriver/releases">https://github.com/mozilla/geckodriver/releases</a>
可在此页面搜索“.zip”,下载OS对应版本
<h3>下载完，放在目录”C:\WebDriver\bin“下，此目录可更改，可在运行时通过java程序指定，也可通过mvn传参,也可设置环境变量，此演示hardcode了</h3>
详情请参考：<a href="https://www.selenium.dev/documentation/en/selenium_installation/installing_webdriver_binaries/">
https://www.selenium.dev/documentation/en/selenium_installation/installing_webdriver_binaries/</a><P>
不需要安装，请不要改名，运行时java会调用



<h1>使用方法</h1>
$git clone ....
<h3>@smoke tag 对应的是输入正确的用户名和密码的测试用例</h3>
$ mvn test -Dcucumber.filter.tags="@smoke"

<h3>@login tag 对应的是执行整个login feature的测试用例</h3>
$ mvn test -Dcucumber.filter.tags="@login"

<p>正文完</p>


以下是学习cucumber时的练习，刚入门
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

