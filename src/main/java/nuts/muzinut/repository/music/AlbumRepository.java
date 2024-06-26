package nuts.muzinut.repository.music;

import nuts.muzinut.domain.music.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    Optional<Album> findByName(String name);

    Optional<Album> findByAlbumImg(String filename);
}
