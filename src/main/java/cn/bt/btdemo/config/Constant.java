package cn.bt.btdemo.config;

public interface Constant {
    String RES_PRE="https://res.ycjdedu.com";
    String JWT_SECRET="7786df7fc3a34e26a61c034d5ec8245d";
    String DEFAULT_PWD="123456789";//登录的默认密码
    interface identity{
        Integer JIAOYUTING = 1;//教育厅
        Integer JIAOYUJU = 2;
        Integer XUEXIAO = 3;
    }
    //第三方服务的常量
    interface THIRDPARTY_SERVICE{
        String WIRIS_SHOW_IMAGE = "http://218.6.69.201:10878/pluginwiris_engine/app/showimage";
    }
    interface status{
        //状态 1：启用 2：停用
        Integer START = 1;
        Integer STOP = 2;
        Integer UPDATEPWD = 3;//修改密码
    }
    interface Upload{
        String UPLOAD_AVATAR="upload/docrouting";//公文流转
        String UPLOAD_COVER="upload/cover";
        String UPLOAD_EDITOR_IMAGE="upload/editor/image";
        String UPLOAD_MATERIAL="upload/material";
        String UPLOAD_APP_ICON="app/icon";
        String UPLOAD_NETWORK = "upload/network"; //视频或者附件
    }

    interface SCHOOL_PROFILE_TYPE{
        String SCHOOL_PROFILE = "school_profile";
        String ORGANIZATION = "organization";
        String RULES_REGULATIONS  ="rules_regulations";
    }

    interface  IGNORE_SYMBOL{
        String NEGATIVE="-";
        String LIKE="%";
    }

    interface STATISTICS{
        String LAST_YEAR_2018_BEGIN="2018-1-1 00:00:00";
        String LAST_YEAR_2018_END="2018-12-31 23:59:59";
        String LAST_YEAR_2017_BEGIN="2017-1-1 00:00:00";
        String LAST_YEAR_2017_END="2017-12-31 23:59:59";
    }

    interface  AGERANGE{
        String AGE_29="29岁以下";
        String AGE_34="30-34岁";
        String AGE_39="35-39岁";
        String AGE_44="40-44岁";
        String AGE_49="45-49岁";
        String AGE_54="50-54岁";
        String AGE_59="55-59岁";
        String AGE_64="60-64岁";
        String AGE_65="65岁以上";
    }

    interface AGEVALUE{
        int AGE_29=29;
        int AGE_34=34;
        int AGE_39=39;
        int AGE_44=44;
        int AGE_49=49;
        int AGE_54=54;
        int AGE_59=59;
        int AGE_64=64;
        int AGE_65=65;

    }


    interface  ATTRTYPE{
        String TEACHER="TEACHER";
        String STUDENT="STUDENT";
        String SUBJECT="SUBJECT";
        String CLASS="CLASS";
    }



}
