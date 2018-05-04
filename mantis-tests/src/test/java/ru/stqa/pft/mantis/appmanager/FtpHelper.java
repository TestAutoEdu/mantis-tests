package ru.stqa.pft.mantis.appmanager;

import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FtpHelper {

}
/** public class FtpHelper {
    private final ApplicationManager app;
    private FTPClient ftp;

    public FtpHelper(ApplicationManager app) {
        this.app = app;
        ftp = new FTPClient();
    } //Инициализируется клиент FTP

    public void upload(File file, String target, String backup) throws IOException { //Метод загружает новый файл, а старый временно переименовывает
        ftp.connect(app.getProperty("ftp.host"));//Устанавливаем соединение с сервером
        ftp.login(app.getProperty("ftp.login"), app.getProperty("ftp.password"));//выполняется вход
        ftp.deleteFile(backup); //Удаляем предыдущую резервную копию файла (если она существует)
        ftp.rename(target, backup);//переименовываем удаленный файл
        ftp.enterLocalPassiveMode();//включаем пассивный режим передачи данных
        ftp.storeFile(target, new FileInputStream(file));//передаем файл, читаем данные по бинарно из локального файла и передаем на удаленную машину
        ftp.disconnect();
    }

    public void restore(String backup, String target) throws IOException { //удаляет новый файл и переименовывает старый обратно
        ftp.connect(app.getProperty("ftp.host"));
        ftp.login(app.getProperty("ftp.login"), app.getProperty("ftp.password"));
        ftp.deleteFile(target);
        ftp.rename(backup, target);
        ftp.disconnect();
    }
}
**/