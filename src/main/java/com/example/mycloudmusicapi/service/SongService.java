package com.example.mycloudmusicapi.service;

import com.example.mycloudmusicapi.domain.PageData;
import com.example.mycloudmusicapi.domain.Song;
import com.example.mycloudmusicapi.mapper.SongMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    @Autowired
    private SongMapper songMapper;

    /**
     * 新建歌曲
     * @param song
     * @return
     */
    public boolean create(Song song) {

        return songMapper.create(song) == 1;
    }


    /**
     * 歌曲详情，MyBatis插件实现分页
     * @param page
     * @param size
     * @return
     */
    public PageData<Song> findAll(int page, int size){
//        开始分页
        //表示从page页开始，每页size条数据
        PageHelper.startPage(page,size);

        List<Song> songs = songMapper.findAll();
        //PageInfo是框架提供的对象
        //这里面有分页数据
        //会对songs中的数据进行过滤
        PageInfo<Song> pageInfo = new PageInfo<>(songs);

//        获取总页数
        int pages = pageInfo.getPages();
//          获取总数量
        int total = (int) pageInfo.getTotal();

        return new PageData(page,pages,total,songs);
    }

    /**
     * 根据id查一条歌曲数据
     * @param id
     * @return
     */
   public Song find(String id){
        return songMapper.find(id);
    }

    public boolean update(Song data) {

       return songMapper.update(data) == 1;
    }

    public boolean delete(String id,String userId) {
        return songMapper.delete(id,userId) ==1;
    }

    /*
    public PageData<Song> findAll(int page, int size){

//        手动实现分页
        int totalCount = songMapper.getCount();

//        偏移量，如当前是第二页，则从1*size开始取
        int offset = (page-1)*size;
//        计算总页数
        int totalPages = totalCount/size;
//        判断是否有不足一页的数据
        if(totalCount%size > 0){
            totalPages++;
        }
        List<Song> datas = songMapper.findAll(size,offset);

        return new PageData(page,totalPages,totalCount,datas);
    }*/

}
