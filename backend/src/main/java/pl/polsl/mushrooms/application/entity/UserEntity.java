package pl.polsl.mushrooms.application.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by pawel_zaqkxkn on 12.03.2017.
 */
@Entity
public class UserEntity {

    @Id
    UUID id;

    public UserEntity(UUID id, String password) {
        this.id = id;
        this.password = password;
    }

    String password;

    private UserEntity() { }
}
