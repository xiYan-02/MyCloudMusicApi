package com.example.mycloudmusicapi.domain;

import com.example.mycloudmusicapi.util.Md5Util;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 歌单标签
 */
@Data
public class Tag extends Common {
    /**
     * 标题
     */
    @NotBlank(message = "标题不能为空")
    private String title;

    /**
     * 子级标签对象
     */
    private List<Tag> data;

//    以下信息是label表的字段，label表复用了这个类

    private String tag_id;

    private String sheet_id;

    private String user_id;

    /**
     * 把集合元素中的sheet_id和user_id填充，以及生成id
     * @param tags
     * @param sheetId
     * @param userId
     * @return
     */
    public static List<Tag> fillData(List<Tag> tags, String sheetId,String userId){
        for (Tag tag:
             tags) {
            tag.setSheet_id(sheetId);
            tag.setUser_id(userId);
            tag.generateId();
        }
        return tags;
    }

    /**
     * 生成label对象的id
     */
    private void generateId() {
//        一个label对象的id为：tag_id+sheet_id+user_id，然后通过md5加密来格式化为32位的字符串
        String id = String.format("%s%s%s",tag_id,sheet_id,user_id);
        setId(Md5Util.encrypt(id));
    }

}