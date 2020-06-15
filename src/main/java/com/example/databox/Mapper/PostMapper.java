package com.example.databox.Mapper;

import com.example.databox.Entity.PostInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper {

    //发布工作
    //插入company表
    @Insert(
            "INSERT INTO `databox`.`company` (`PositionID`, `Company`, `Url`,`Position`, `City`, `Function`, `Education`, `Experience`, `Description`) "+
            "VALUES (#{PositionID}, #{Company}, #{Url},#{Position}, #{City}, #{Function}, #{Education}, #{Experience}, #{Description});"
    )
        Integer savePostJob(PostInfo postInfo);


    //查看发布工作
//    @Select("select * from company c join Company c on c.Company=c.Company order by PositionID desc")
//    List<PostInfo> getallmessage();

//    @Select("select * from company c join Company c on c.Company=c.Company where PositionID=#{PositionID};")
//    List<PostInfo> getPositionID(Integer PostInfo);

    @Select("SELECT * FROM company where PositionID=#{PositionID}")
    PostInfo getContent(Integer PositionID);



}
