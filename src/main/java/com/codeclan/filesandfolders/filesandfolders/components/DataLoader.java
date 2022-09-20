package com.codeclan.filesandfolders.filesandfolders.components;

import com.codeclan.filesandfolders.filesandfolders.models.File;
import com.codeclan.filesandfolders.filesandfolders.models.Folder;
import com.codeclan.filesandfolders.filesandfolders.models.Person;
import com.codeclan.filesandfolders.filesandfolders.repositories.FileRepository;
import com.codeclan.filesandfolders.filesandfolders.repositories.FolderRepository;
import com.codeclan.filesandfolders.filesandfolders.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner{

    public DataLoader() {

    }

    @Autowired
    PersonRepository personRepository;

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Person person = new Person("James");
        personRepository.save(person);

        Folder folder = new Folder("work", person);
        folderRepository.save(folder);

        File file = new File("file", ".txt", 10, folder);
        fileRepository.save(file);

        folder.addFile(file);
        folderRepository.save(folder);

        person.addFolder(folder);
        personRepository.save(person);
    }
}
