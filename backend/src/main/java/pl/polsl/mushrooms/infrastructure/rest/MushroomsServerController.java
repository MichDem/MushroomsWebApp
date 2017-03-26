package pl.polsl.mushrooms.infrastructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.mushrooms.application.user.command.CreateUserCommand;
import pl.polsl.mushrooms.application.user.presentation.UserProfilePresentation;
import pl.polsl.mushrooms.infrastructure.command.CommandGateway;


/**
 * Created by pawel_zaqkxkn on 12.03.2017.
 */
@RestController
@RequestMapping("/mushrooms/api/1.0/")
public class MushroomsServerController {


    private final CommandGateway commandGateway;

    @Autowired
    public MushroomsServerController(final CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @RequestMapping(path = "create-user", method = RequestMethod.POST)
    public ResponseEntity<UserProfilePresentation> createUser(@RequestBody CreateUserCommand command) {

        final UserProfilePresentation userProfile = commandGateway.dispatch(command);

        if (userProfile == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userProfile, HttpStatus.ACCEPTED);
    }


//    @RequestMapping(path = "store-image", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public StoreImageResponse receiveImage(
//            @RequestParam("file") List<MultipartFile> files, @RequestParam("info") String info) {
//
//        ImageData imageData = new ImageData(files, info);
//        StoreImageResponse response = imageService.storeImage(imageData);
//
//        return response;
//    }
}
