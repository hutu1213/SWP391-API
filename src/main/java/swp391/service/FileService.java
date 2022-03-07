package swp391.service;

import org.springframework.web.multipart.MultipartFile;
import swp391.entity.File;

import java.util.List;

public interface FileService {
    File uploadFile(MultipartFile multipartFile);

    List<File> getAll();

    File getById(Long id);


    boolean isExisted(Long fileId);
}