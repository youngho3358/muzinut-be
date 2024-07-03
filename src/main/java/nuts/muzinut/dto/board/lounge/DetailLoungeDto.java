package nuts.muzinut.dto.board.lounge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nuts.muzinut.dto.board.DetailBaseDto;
import nuts.muzinut.dto.board.comment.CommentDto;

import java.util.ArrayList;
import java.util.List;

//특정 어드민 게시판을 반환할때 사용하는 dto
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailLoungeDto extends DetailBaseDto {

    private Long id;
    private String writer;
    private String profileImg;
    private int view;
    private int commentSize;
    private String quillFilename;
    private int likeCount;

    private List<CommentDto> comments = new ArrayList<>();

    public DetailLoungeDto(String writer, int view) {
        this.writer = writer;
        this.view = view;
    }

    public DetailLoungeDto(Long id, String writer, int view, String quillFilename, String profileImg) {
        this.id = id;
        this.writer = writer;
        this.view = view;
        this.quillFilename = quillFilename;
        this.profileImg = profileImg;
    }
}
