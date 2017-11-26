
### 安装Git

### 配置

```git
  git config --global user.email "you@example.com"
  git config --global user.name "Your Name"
```

### 初始化仓库


```git
$ mkdir learngit
$ cd learngit
$ pwd  //显示文件路径
$ cd ..
```

**如果你使用Windows系统，为了避免遇到各种莫名其妙的问题，请确保目录名（包括父目录）不包含中文。**


```git
$ git init
```

可以发现当前目录下多了一个.git的目录，这个目录是Git来跟踪管理版本库的，没事千万不要手动修改这个目录里面的文件，不然改乱了，就把Git仓库给破坏了。

编写一个readme.txt文件，内容如下：

>Git is a version control system.
>Git is free software.

```git
$ git add readme.txt
$ git commit -m "add README"
```

>Git is a distributed version control system.
>Git is free software.

`git status` 命令可以让我们时刻掌握仓库当前的状态

`git log` 可以告诉我们提交的历史记录
`git log --pretty=oneline` 只显示一行提交记录

```git
4ef7a1cdb7a8f36839eb88791cc60b14f32ebc57 (HEAD -> master) change README
27982589c0b33e0b9dc3d3f6d7ed56550d6278ce add README
```

`4ef7a1cdb7a8f36839eb88791cc60b14f32ebc57`就是版本号


下面命令是回退到上一个版本

```git
$ git reset --hard HEAD^ 
```

上一个版本就是`HEAD^`，上上一个版本就是`HEAD^^`，当然往上100个版本写100个^比较容易数不过来，所以写成`HEAD~100`。


HEAD指向的版本就是当前版本，因此，Git允许我们在版本的历史之间穿梭，使用命令`git reset --hard commit_id`。

穿梭前，用`git log`可以查看提交历史，以便确定要回退到哪个版本。

要重返未来，用`git reflog`查看命令历史，以便确定要回到未来的哪个版本。

### 工作区 和 暂存区

工作区（Working Directory）

版本库（Repository）

工作区有一个隐藏目录.git，这个不算工作区，而是Git的版本库。 

Git的版本库里存了很多东西，其中最重要的就是称为stage（或者叫index）的暂存区，还有Git为我们自动创建的第一个分支`master`，以及指向`master`的一个指针叫`HEAD`

第一步是用`git add`把文件添加进去，实际上就是把文件修改添加到暂存区；

第二步是用`git commit`提交更改，实际上就是把暂存区的所有内容提交到当前分支。

### 撤销修改

命令git checkout -- readme.txt意思就是，把readme.txt文件在工作区的修改全部撤销，这里有两种情况：

一种是readme.txt自修改后还没有被放到暂存区，现在，撤销修改就回到和版本库一模一样的状态；

一种是readme.txt已经添加到暂存区后，又作了修改，现在，撤销修改就回到添加到暂存区后的状态。

### 添加远程库

1. Github上创建新仓库

2. 在本地的learngit仓库下运行命令：

```git
$ git remote add origin git@github.com:michaelliao/learngit.git

```

3. 推送到远程仓库

```
$ git push -u origin master

```

用`git push`命令，实际上是把当前分支`master`推送到远程。由于远程库是空的，我们第一次推送`master`分支时，加上了`-u`参数，Git不但会把本地的`master`分支内容推送的远程新的`master`分支，还会把本地的`master`分支和远程的`master`分支关联起来，在以后的推送或者拉取时就可以简化命令。

### 克隆仓库

```git
$ git clone git@github.com:michaelliao/gitskills.git
```

Git支持多种协议，包括`https`，但通过`ssh`支持的原生`git`协议速度最快。