package com.pang.card.initialization;

import com.pang.card.services.MacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author pang
 * @version V1.0
 * @ClassName: MacSetInit
 * @Package com.pang.card.initialization
 * @description:
 * @date 2019/11/16 14:51
 */
@Component
public class MacSetInit implements CommandLineRunner {
    @Autowired
    private MacService macService;
    public static Set<String> macSet=new HashSet<>();
    @Override
    public void run(String... args) throws Exception {
        macSet=macService.getAllMac();
    }
}
