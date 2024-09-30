package org.stone.thiagovb62.Controllers;

import com.github.dockerjava.api.model.Container;
import org.springframework.web.bind.annotation.*;
import org.stone.thiagovb62.service.DockerService;

import java.util.List;

@RestController
@RequestMapping("/containers")
public class DockerContainersController {

    private final DockerService dockerService;


    public DockerContainersController(DockerService dockerService) {
        this.dockerService = dockerService;
    }

    @GetMapping("/filter")
    public List<Container> filterImages(@RequestParam(required = false,defaultValue ="true") Boolean all){
        return dockerService.listContainers(all);
    }


    @PostMapping("/{containerId}/start")
    public void startContainer(@PathVariable String containerId){
        dockerService.startContainer(containerId);
    }

    @PostMapping("/{containerId}/stop")
    public void stopContainer(@PathVariable String containerId){
        dockerService.stopContainer(containerId);
    }

    @DeleteMapping("/{containerId}")
    public void deleteContainer(@PathVariable String containerId){
        dockerService.deleteContainer(containerId);
    }

    @PostMapping("/create")
    public void createContainer(@RequestParam String image){
        dockerService.createContainer(image);
    }
}
