package nuts.muzinut.domain.music;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nuts.muzinut.domain.member.User;
import nuts.muzinut.dto.music.AlbumDto;
import nuts.muzinut.dto.music.ModifyAlbumDto;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Album {

    @Id @GeneratedValue
    @Column(name = "album_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    private String name;
    private String intro;

    @Column(name = "album_img")
    private String albumImg; // 이미지 이름

    @OneToMany(mappedBy = "album")
    private List<Song> songList = new ArrayList<>();

    //연관 관계 메서드
    public void addSongIntoAlbum(Song song) {
        this.songList.add(song);
        song.setAlbum(this);
    }

    // 생성 메서드
    public Album(User user, String albumName, String bio, String albumImg) {
        this.user = user;
        this.name = albumName;
        this.intro = bio;
        this.albumImg = albumImg;
    }

    public Album(String albumImg, String intro, String name, User user, Long id) {
        this.albumImg = albumImg;
        this.intro = intro;
        this.name = name;
        this.user = user;
        this.id = id;
    }
}