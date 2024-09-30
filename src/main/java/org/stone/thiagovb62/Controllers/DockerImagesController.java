package org.stone.thiagovb62.Controllers;

import com.github.dockerjava.api.model.Image;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.stone.thiagovb62.service.DockerService;

import java.util.List;


@RestController
@RequestMapping("/images")
public class DockerImagesController {

    private final DockerService dockerService;


    public DockerImagesController(DockerService dockerService) {
        this.dockerService = dockerService;
    }

    @GetMapping("/list")
    public List<Image> listImages(){
        return dockerService.listImages();
    }

    @GetMapping("/filter")
    public List<Image> filterImages(@RequestParam(required = false,defaultValue ="image-") String imageName){
        return dockerService.filterImages(imageName);
    }
}
