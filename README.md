# Visualization
git clone https://github.com/tchennech/Visualization.git
***
1. 开发前一定要 git pull  
2. 开发完后 先用 git status 检查什么文件被修改了，如果有意料之外的文件自己处理不了再找人处理  
3. 提交步骤：  
i) git add .  
ii) git commit -m "本次提交时为什么的信息"  
iii) git push  
***
## database
create DATABASE ed_vs;  
use ed_vs;  
set names utf8;  
source 项目路径/Visualization/back/src/main/resources/sql/database.sql
***
## WEB 
1. npm install -all 
***
## SSM
1. idea import （pom.xml）
## idea配置
1. maven:  
i) 装完以后打开idea偏好设置, 搜索maven
ii) 修改 maven home directory 为你的安装路径  
iii) 按需修改setting和repository的路径（可以不改）
iiii) 可以选择自己下依赖的包，也可以把压缩文件直接解压到repository的路径
2. 添加tomcat  
i) 右上角 Edit Configurations  
ii) 添加tomcat路径  
iii) 在deployment中，添加Artifact->Visualization:war  
&emsp; 将Application centext 改为/  
***
## 运行vue项目
npm run dev
## 运行SSM
点开始