> - [参考文章](https://blog.csdn.net/u011535541/article/details/83379151)
> - 如何是一个目录接受Git管理？
> - Git如何管理目录中的文件
>   - 文件发生了改动，如何对git进行操作？
>   - 如何撤销文件的修改和删除文件（恢复删除）？
> - 本地仓库如何和Github远程仓库连接？
>   - 将本地仓库添加到github？
>   - 将github仓库克隆到本地仓库？
> - 分支管理
>   - 如何创建和合并分支？
>   - 如何解决冲突？

[TOC]



# 一：Git工作流程

<img src="https://img.mukewang.com/59c31e4400013bc911720340.png" alt="图片描述" style="zoom:200%;" />

Workspace：工作区
 Index / Stage：暂存区
 Repository：仓库区（或本地仓库）
 Remote：远程仓库

# 二：环境配置

> **因为Git是分布式版本控制系统，所以需要填写用户名和邮箱作为一个标识。**

安装完成后，在命令行输入内容：

<img src="https://img.mukewang.com/59c1d041000110d906460213.jpg" alt="图片描述" style="zoom:150%;" />

<font color ='red'>注意：git config --global 参数，有了这个参数，表示你这台机器上所有的Git仓库都会使用这个配置，当然也可以对某个仓库指定的不同的用户名和邮箱。</font>

# 三：上手操作

## 1、创建版本库

> 例如：D盘 –> www下 目录下新建一个testgit版本库

![图片描述](https://img.mukewang.com/59c1d1060001909005780268.png)

`mkdir test`       创建一个目录名为test的空目录文件

`pwd`     查看当前所在目录：

> 1**.git init                  --把该目录变成git可以管理的仓库**
>
> 这时候你当前testgit目录下会多了一个.git的目录，这个目录是Git来跟踪管理版本的。

> 2.git add 文件名  --提交文件到暂存区
>
> 3.git  status     --查看状态
>
> 4. git commit -m "描述文字“ 

---

<font color = 'red'>修改了文件的话？</font>

> 比如我在下面添加一行2222222222内容，继续使用git status来查看下结果，如下：

<img src="https://img.mukewang.com/59c1d2500001634606170171.png" alt="图片描述" style="zoom:150%;" />

`上面的命令告诉我们 readme.txt文件已被修改，但是未被提交的修改。`

`接下来我想看下readme.txt文件到底改了什么内容，如何查看呢？可以使用如下命令`

<img src="https://img.mukewang.com/59c1d2cb00010a0304960202.png" alt="图片描述" style="zoom:150%;" />

`如上可以看到，readme.txt文件内容从一行11111111改成 二行 添加了一行22222222内容。`

> **知道了对readme.txt文件做了什么修改后，我们可以放心的提交到仓库了，提交修改和提交文件是一样的2步(第一步是git add 第二步是：git commit)。**

## 2、版本回退

> **想<u>查看下历史记录</u>，如何查呢？我们现在可以使用命令 <u>git log</u> 演示如下所示：**

<img src="https://img.mukewang.com/59c1d34e0001a1ac06050304.png" alt="图片描述" style="zoom:150%;" />

`如果嫌上面显示的信息太多的话，我们可以使用命令 git log –pretty=oneline 演示如下`

<img src="https://img.mukewang.com/59c1d3fc00013ad206040097.png" alt="图片描述" style="zoom:200%;" />

<font color = 'red'>**git log- -pretty=oneline**</font>

> 现在我**想使用版本回退操作**，我想把当前的版本回退到上一个版本，要使用什么命令呢？

> - `第一种是：git reset --hard HEAD^` 那么如果要回退到上上个版本只需把HEAD^ 改成 HEAD^^  以此类推。那如果要回退到前100个版本的话，使用上面的方法肯定不方便，我们可以使用下面的简便命令操作：git reset --hard  HEAD~100 即可。

`如果想回退到上一个版本的命令如下操作：`

<img src="https://img.mukewang.com/59c1d429000199fc04610105.png" alt="图片描述" style="zoom:150%;" />

`通过命令cat readme.txt查看`

<img src="https://img.mukewang.com/59c1d4470001fcdc04360085.png" alt="图片描述" style="zoom:150%;" />

**<font color = 'red'>cat 文件名</font>**--查看文件

> **我们看到 增加333333 内容我们没有看到了，但是现在我想回退到最新的版本，如：有333333的内容要如何恢复呢？我们可以通过版本号回退，使用命令方法如下：**

**<font color = 'red'>git reset --hard 版本号 </font>**

> 要如何知道增加3333内容的版本号呢？

<font color = 'red'>**git reflog**</font> 演示如下：

<img src="https://img.mukewang.com/59c1d51a0001d5fc05100122.png" alt="图片描述" style="zoom:150%;" />

> <font color = 'red'>**git reset --hard 6fcfc89来恢复**</font>

## 3、Git撤销修改和删除文件操作

### 3.1、撤销修改

> **比如我现在在readme.txt文件里面增加一行 内容为555555555555**
>
> - 第一：如果我知道要**删掉**那些内容的话，直接手动更改去掉那些需要的文件，然后**add**添加到暂存区，最后**commit**掉。
>
> - 第二：我可以按以前的方法**直接恢复到上一个版本**。使用 **git reset --hard HEAD^**

`但是现在我不想使用上面的2种方法，我想直接想使用撤销命令该如何操作呢？`

<font color = 'red'>**git checkout -- file 可以丢弃工作区的修改**</font>

> 这里说的工作区就是<u>电脑本地</u>，但还没有提交给暂存区

`有2种情况，如下：`

1.readme.txt自动修改后，还没有放到暂存区，使用 撤销修改就回到和版本库一模一样的状态。
 2.另外一种是readme.txt已经放入暂存区了，接着又作了修改，撤销修改就回到添加暂存区后的状态。
 <img src="https://img.mukewang.com/59c1d6ca0001782f06160482.png" alt="图片描述" style="zoom:200%;" />

**<font color = 'red'>注意：命令git checkout -- readme.txt 中的 -- 很重要，如果没有 -- 的话，那么命令变成创建分支了。</font>**

### 3.2、删除文件

<img src="https://img.mukewang.com/59c1d6de0001a31606390392.png" alt="图片描述" style="zoom:150%;" />

**在版本库中恢复此文件如何操作呢？**

<font color='red'>**git checkout -- b.txt**</font>

<img src="https://img.mukewang.com/59c1d7980001368e05570244.png" alt="图片描述" style="zoom:150%;" />

<font color = 'red'>**注意：恢复删除的条件是删除修改没有提交给暂存区。**</font>

## 4.远程仓库

### 4.1 将本地仓库与github仓库连接

<img src="https://img.mukewang.com/59c1d8a70001c86206320252.png" alt="图片描述" style="zoom:150%;" />

> 我们<u>第一次</u>推送master分支时，<u>加上 –u参数</u>
>
> 推送过一次后，只要本地作了提交，就可以通过如下命令：
>
> **<font color = 'red'>git push origin master</font>**

### 4.2 从远程库（Github）克隆

<img src="https://img.mukewang.com/59c1d9860001e0d806370127.png" alt="图片描述" style="zoom:150%;" />

**<font color = 'red'>git clone 要克隆仓库的地址</font>**

### 4.3 创建与合并分支

<img src="https://img.mukewang.com/59c1d9aa0001c15604080167.png" alt="图片描述" style="zoom:150%;" />

> **查看分支：<font color = 'red'>git branch</font>**
>
> **创建分支：<font color = 'red'>git branch name</font>**
>
> **切换分支：<font color = 'red'>git checkout name</font>**
>
> **创建+切换分支：<font color = 'red'>git checkout –b name</font>**
>
> **合并某分支到当前分支：<font color = 'red'>git merge name</font>**
>
> **删除分支：<font color = 'red'>git branch –d name</font>**

### 4.4 冲突解决

![](https://img.mukewang.com/59c1daff000106eb06340589.png)![图片描述](https://img.mukewang.com/59c1db410001036105690462.png)

![图片描述](https://img.mukewang.com/59c1daaf0001133205840500.png)

![图片描述](https://img.mukewang.com/59c1daff000106eb06340589.png)

![图片描述](https://img.mukewang.com/59c1dbaf00015f2205770266.png)

