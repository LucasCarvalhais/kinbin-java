package com.kinbin.configuration;

import com.kinbin.core.model.board.Board;
import com.kinbin.core.model.board.BoardImpl;
import com.kinbin.core.model.kinbin.Kinbin;
import com.kinbin.core.model.kinbin.KinbinImpl;
import com.kinbin.core.service.GameService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan(basePackageClasses = GameService.class)
public class Config {

    @Bean
    public Kinbin getKinbin() {
        return new KinbinImpl();
    }

    @Bean
    public Board getBoard() {
        return new BoardImpl();
    }

}
