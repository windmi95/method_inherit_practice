package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.prefs.Preferences;

public class 게임_설정 {
    private Clip clip;
    private boolean isPlaying = false;
    Preferences preferences = Preferences.userRoot();
    ObjectMapper objectMapper = new ObjectMapper();
    boolean 게임_bgm_틀기 = false;
    boolean 게임설정_메뉴_진행중 = true;

    boolean isDay = true;


    public 게임_설정() {
        JFrame frame = new JFrame("MP3 Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,100);

        JTextField fieldPathField = new JTextField(20);
        JButton playButton = new JButton("Play");
        JButton stopButton = new JButton("Stop");

        JPanel panel = new JPanel();
        panel.add(fieldPathField);
        panel.add(playButton);
        panel.add(stopButton);

        frame.add(panel);
        frame.setVisible(true);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!게임_bgm_틀기) {
                    File file = new File(fieldPathField.getText());
                    FileInputStream fis = null;
                    try {
                        fis = new FileInputStream("C:\\Users\\User\\Downloads\\y2mate.com - 로이킴 Roy Kim  괜찮을거야 Live Clip  2023 ROY KIM CONCERT Roy Note.mp3");
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    BufferedInputStream bis = new BufferedInputStream(fis);

                    Thread bgmThread  = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                try {
                                    AudioInputStream ais = AudioSystem.getAudioInputStream(bis);
                                    clip = AudioSystem.getClip();
                                    clip.open(ais);
                                    clip.start();
                                    게임_bgm_틀기 = true;
                                } catch (FileNotFoundException ex) {
                                    throw new RuntimeException(ex);
                                }
                            } catch (Exception e1) {
                                System.out.println("음악 파일을 찾을 수 없습니다.");
                            }
                        }
                    });
                    bgmThread.start();
                }
            }
    });

}
private void 음악_재생(String filePath) {
    try {
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(filePath);
        BufferedInputStream bis = new BufferedInputStream(fis);

    } catch (Exception e) {
        System.out.println("음악 파일을 찾을 수 없습니다.");
    }
}

    public boolean 게임_bgm_효과_적용() {
        if (게임_bgm_틀기) {
            Thread bgmThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("==================배경 음악 재생중==================");
                    while (게임_bgm_틀기) {

                    }
                }
            });
            bgmThread.start();
            return true;
        }
        return false;
    }

    public void 게임_bgm_여부_확인() {
        System.out.println("bgm 효과를 적용하시겠습니까?");
        System.out.println("1.효과를 적용한다. 2.메인 메뉴로 이동한다.");
    }
    public void 게임_설정_메뉴_보여주기() {
        System.out.println("========================게임 설정 메뉴========================");
        System.out.println("1.게임 bgm 2.게임 저장 3.불러오기 4.메인 메뉴로 이동");
        System.out.println("어떤 것을 선택하시겠습니까?");
    }
    public void 게임_저장하기(캐릭터 게임_캐릭터) {
        String 캐릭터jsonString = "";
        try {
            캐릭터jsonString = objectMapper.writeValueAsString(게임_캐릭터);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        preferences.put("캐릭터 정보",캐릭터jsonString);
        System.out.println("캐릭터 체력 -> " + 게임_캐릭터.체력);
        System.out.println("캐릭터 근력 -> " + 게임_캐릭터.근력);
        System.out.println("캐릭터 등급 -> " + 게임_캐릭터.등급);
    }
    public 캐릭터 게임_정보_불러오기() {
        String 캐릭터정보_저장된_객체 = preferences.get("캐릭터 정보", "없음");
        if (캐릭터정보_저장된_객체 != null) {
            try {
                캐릭터 게임_캐릭터 = objectMapper.readValue(캐릭터정보_저장된_객체, 캐릭터.class);
                System.out.println("게임 캐릭터 정보를 불러왔습니다.");
                return 게임_캐릭터;
            } catch (JsonMappingException e) {
                throw new RuntimeException(e);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("저장된 게임 정보가 없습니다.");
            return null;
        }
    }
    public void 타이머_설정() {
        TimerTask task = new TimerTask() {//현재 날짜와 시간 반영
            @Override
            public void run() {//밤 낮을 구분
                if (isDay) {
                    long delay = 12 * 60 * 60 * 1000L; // 12시간 기준
                    isDay = false;
                } else {
                    isDay = true;
                }
                /*System.out.println(new Date() + " : Executing the task from"
                + Thread.currentThread().getName());*/
            }
        };
        Timer timer = new Timer("Timer", true);
        long delay = 3000L;//3초마다 run 실행
        System.out.println(new Date() + " : Scheduling");
        timer.schedule(task, delay);
    }

}

