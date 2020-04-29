package com.example.mycloudmusicapi.controller.v1;

import com.example.mycloudmusicapi.annotation.Authorization;
import com.example.mycloudmusicapi.annotation.CurrentUser;
import com.example.mycloudmusicapi.domain.Song;
import com.example.mycloudmusicapi.domain.User;
import com.example.mycloudmusicapi.exception.MyException;
import com.example.mycloudmusicapi.response.Response;
import com.example.mycloudmusicapi.response.ResponseCode;
import com.example.mycloudmusicapi.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class SongController {

    @Autowired
    private SongService songService;

    /**
     * 创建歌曲
     * @param song
     * @param user
     * @return
     */
    @PostMapping("/songs")
    @Authorization
    public Object create(@Validated @RequestBody Song song, @CurrentUser User user){
        song.setUserId(user.getId());
        if(!songService.create(song)){
//            添加异常
            throw new MyException(ResponseCode.UPDATE_FILED);
        }
        return song.getId();

    }

    /**
     * 歌曲详情
     * @param id
     * @return
     */
    @GetMapping("/songs/{id}")
    public Song find(@PathVariable("id") String id){
        return checkSong(id);
    }

    @GetMapping("/songs")
    public Object findAll(@RequestParam(defaultValue = "10") int size,@RequestParam(defaultValue = "1")int page){
        return songService.findAll(page,size);
    }

    @Authorization
    @PatchMapping("/songs/{id}")
    public String update(@PathVariable("id")String id, @RequestBody Song data,@CurrentUser User currentUser){
        data = checkSong(id);
        data.setUserId(currentUser.getId());

        if(!songService.update(data)){
            throw new MyException(ResponseCode.UPDATE_FILED);
        }
        return data.getId();
    }

    @DeleteMapping("/songs/{id}")
    @Authorization
    public Object delete(@PathVariable("id") String id,@CurrentUser User currentUser){
        checkSong(id);
        if(!songService.delete(id,currentUser.getId())){
            throw new MyException(ResponseCode.UPDATE_FILED);
        }
        return Response.success(null);
    }


    public Song checkSong(String id){
        Song song = songService.find(id);
        if(song == null){
            throw new MyException(ResponseCode.SONG_NOT_EXITS);
        }
        return song;
    }

}
