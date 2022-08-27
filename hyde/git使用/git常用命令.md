# Git的常用使用命令

| 作者：Hyde | 日期：2022/08/24 |
| ------- | ------------- |

### Git安装后设置的全局用户名和邮箱

- **git config --global user.name "username"**

- **git config --global user.email "email@hyde.com"**

### 创建仓库的常用命令

- **mkdir Hyde**                      **//创建名为Hyde的文件夹**

- **git init**                             **//初始化仓库  (给仓库添加.git文件夹)**

- **git remote add origin <u>git@gitee.com:ychyde/hyde-blog.git</u>**       **//关联git仓库链接需要初始化仓库和关联链接后才能进行下拉上传操作**

- **git clone <u>git@gitee.com:ychyde/hyde-blog.git</u>**        **//克隆远程仓库到本地**

### 上传文件的常用命令

- **git add test.txt**             **//添加文件test.txt(个人理解是先将其放入一个类似缓存的区间，为提交做准备)**

- **git commit -m "first commit"**      **//提交add所添加的文件，双引号内表示注释，此时还未正式上传到gitee**

- **git push origin master**       **//上传master分支内所提交的文件，master为管理员权限**

### 多人协作

- **git checkout -b hyde**           **//创建并切换到分支hyde**

- **git branch hyde**                    **//创建分支hyde**

- **git checkout hyde**               **//切换到分支hyde**

- **git fetch**                                 **//获取所有分支(由于某些分支本地并未获取，所以无法切换到那些未被获取的分支里)**

- **git branch -d hyde**              **//删除分支hyde**

- **git merge hyde**                    **//合并分支hyde到主分支master**

- **git push origin hyde**           **//提交分支hyde到远程仓库**

- **git pull origin master**         **//抓取master分支(从gitee平台上下拉当前master分支最新的项目版本 )**

 
