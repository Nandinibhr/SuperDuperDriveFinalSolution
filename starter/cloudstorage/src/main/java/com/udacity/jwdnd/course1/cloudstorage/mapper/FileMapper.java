package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface FileMapper
{
    @Select("SELECT * FROM FILES WHERE fileId = #{fileId} ")
    File select(Integer fileId);

    @Select("SELECT * FROM FILES WHERE userid = #{userid} ")
    List<File> getAllFiles(Integer userid);

    @Insert("INSERT INTO FILES(filename, contenttype , filesize , userid) VALUES( #{filename}, #{contenttype} , #{filesize}, #{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
     void insert(File file);

    @Delete("DELETE FROM FILES WHERE fileId = #{fileId} AND userid =#{userid}")
     void delete(Integer fileId, Integer userid);

}
