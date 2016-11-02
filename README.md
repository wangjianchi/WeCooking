# WeCooking
 MVP + Rxjava + Retrofit + dagger 

 model:基础类-ApiResponse:接口返回的统一格式
 presenter:基础类-BasePresenter: View和persenter连接的基础方法
 view:基础类-BaseActivity:初始化butterknife,初始化组件，抽象方法initEventAndData();
 
 
 dagger教程：https://github.com/luxiaoming/dagger2Demo
 

 数据流程示例：
 1.MainActivity:继承自BaseActivity,BA inject对象mPresenter
     @Override
     protected void initEventAndData() {
         mPresenter.getListData();//获取列表
         }
 2.MainPresenter：继承自BasePresenter,BP inject对象dataManager
 
 
 
 