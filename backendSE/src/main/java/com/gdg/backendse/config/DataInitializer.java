package com.gdg.backendse.config; // 패키지는 config에 맞춰 설정

import com.gdg.backendse.domain.Edu;
import com.gdg.backendse.repository.EduRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import static com.gdg.backendse.domain.EduCategory.CONSONANT;
import static com.gdg.backendse.domain.EduCategory.VOWEL;

@Component // Spring Boot 실행 시 자동 실행
public class DataInitializer {

    private final EduRepository eduRepository;

    public DataInitializer(EduRepository eduRepository) {
        this.eduRepository = eduRepository;
    }

    @PostConstruct // 애플리케이션 실행 후 한 번 실행됨
    @Transactional
    public void init() {
        List<Edu> eduList = List.of(
                new Edu("ㄱ", "ㄱ을 수어로 배워봅시다.", "ㄱ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005695/MOV000359820_320X240.mp4", 0, CONSONANT),
                new Edu("ㄴ", "ㄴ을 수어로 배워봅시다.", "ㄴ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220811/1009739/MOV000360036_320X240.mp4", 0, CONSONANT),
                new Edu("ㄷ", "ㄷ을 수어로 배워봅시다.", "ㄷ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220811/1009752/MOV000360049_320X240.mp4", 0, CONSONANT),
                new Edu("ㄹ", "ㄹ을 수어로 배워봅시다.", "ㄹ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005858/MOV000359860_320X240.mp4", 0, CONSONANT),
                new Edu("ㅁ", "ㅁ을 수어로 배워봅시다.", "ㅁ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220811/1009748/MOV000360045_320X240.mp4", 0,CONSONANT),
                new Edu("ㅂ", "ㅂ을 수어로 배워봅시다.", "ㅂ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220803/1006271/MOV000359919_320X240.mp4", 0, CONSONANT),
                new Edu("ㅅ", "ㅅ을 수어로 배워봅시다.", "ㅅ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005893/MOV000359895_320X240.mp4", 0, CONSONANT),
                new Edu("ㅇ", "ㅇ을 수어로 배워봅시다.", "ㅇ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220811/1009745/MOV000360042_320X240.mp4", 0, CONSONANT),
                new Edu("ㅈ", "ㅈ을 수어로 배워봅시다.", "ㅈ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220727/1001950/MOV000359527_320X240.mp4", 0, CONSONANT),
                new Edu("ㅊ", "ㅊ을 수어로 배워봅시다.", "ㅊ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005761/MOV000359838_320X240.mp4", 0, CONSONANT),
                new Edu("ㅋ", "ㅋ을 수어로 배워봅시다.", "ㅋ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220811/1009754/MOV000360051_320X240.mp4", 0, CONSONANT),
                new Edu("ㅌ", "ㅌ을 수어로 배워봅시다.", "ㅌ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005763/MOV000359840_320X240.mp4", 0, CONSONANT),
                new Edu("ㅍ", "ㅍ을 수어로 배워봅시다.", "ㅍ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005870/MOV000359872_320X240.mp4", 0, CONSONANT),
                new Edu("ㅎ", "ㅎ을 수어로 배워봅시다.", "ㅎ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005694/MOV000359819_320X240.mp4", 0, CONSONANT),
                new Edu("ㄲ", "ㄲ을 수어로 배워봅시다.", "ㄲ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220803/1006230/MOV000359911_700X466.mp4", 0, CONSONANT),
                new Edu("ㄸ", "ㄸ을 수어로 배워봅시다.", "ㄸ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220811/1009741/MOV000360038_700X466.mp4", 0, CONSONANT),
                new Edu("ㅃ", "ㅃ을 수어로 배워봅시다.", "ㅃ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005891/MOV000359893_700X466.mp4", 0, CONSONANT),
                new Edu("ㅆ", "ㅆ을 수어로 배워봅시다.", "ㅆ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005854/MOV000359856_700X466.mp4", 0, CONSONANT),
                new Edu("ㅉ", "ㅉ을 수어로 배워봅시다.", "ㅉ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005759/MOV000359836_700X466.mp4", 0, CONSONANT),

                new Edu("ㅏ", "ㅏ을 수어로 배워봅시다.", "ㅏ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005855/MOV000359857_320X240.mp4", 0, VOWEL),
                new Edu("ㅑ", "ㅑ을 수어로 배워봅시다.", "ㅑ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005755/MOV000359832_320X240.mp4", 0, VOWEL),
                new Edu("ㅓ", "ㅓ을 수어로 배워봅시다.", "ㅓ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005757/MOV000359834_320X240.mp4", 0, VOWEL),
                new Edu("ㅕ", "ㅕ을 수어로 배워봅시다.", "ㅕ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005884/MOV000359886_320X240.mp4", 0, VOWEL),
                new Edu("ㅗ", "ㅗ을 수어로 배워봅시다.", "ㅗ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005885/MOV000359887_320X240.mp4", 0, VOWEL),
                new Edu("ㅛ", "ㅛ을 수어로 배워봅시다.", "ㅛ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005888/MOV000359890_320X240.mp4", 0, VOWEL),
                new Edu("ㅜ", "ㅜ을 수어로 배워봅시다.", "ㅜ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220727/1001927/MOV000359504_320X240.mp4", 0, VOWEL),
                new Edu("ㅠ", "ㅠ을 수어로 배워봅시다.", "ㅠ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220811/1009753/MOV000360050_320X240.mp4", 0, VOWEL),
                new Edu("ㅡ", "ㅡ을 수어로 배워봅시다.", "ㅡ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005890/MOV000359892_320X240.mp4", 0, VOWEL),
                new Edu("ㅣ", "ㅣ을 수어로 배워봅시다.", "ㅣ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220811/1009678/MOV000359988_320X240.mp4", 0, VOWEL),
                new Edu("ㅐ", "ㅐ을 수어로 배워봅시다.", "ㅐ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005754/MOV000359831_320X240.mp4", 0, VOWEL),
                new Edu("ㅒ", "ㅒ을 수어로 배워봅시다.", "ㅒ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005756/MOV000359833_320X240.mp4", 0, VOWEL),
                new Edu("ㅔ", "ㅔ을 수어로 배워봅시다.", "ㅔ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220727/1001923/MOV000359500_320X240.mp4", 0, VOWEL),
                new Edu("ㅖ", "ㅖ을 수어로 배워봅시다.", "ㅖ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220811/1009749/MOV000360046_320X240.mp4", 0, VOWEL),
                new Edu("ㅢ", "ㅢ을 수어로 배워봅시다.", "ㅢ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220727/1001948/MOV000359525_320X240.mp4", 0, VOWEL),
                new Edu("ㅚ", "ㅚ을 수어로 배워봅시다.", "ㅚ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220727/1001925/MOV000359502_320X240.mp4", 0, VOWEL),
                new Edu("ㅟ", "ㅟ을 수어로 배워봅시다.", "ㅟ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20240118/1261087/MOV000361352_320X240.mp4", 0, VOWEL),
                new Edu("ㅘ", "ㅘ을 수어로 배워봅시다.", "ㅘ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005886/MOV000359888_700X466.mp4", 0, VOWEL),
                new Edu("ㅙ", "ㅙ을 수어로 배워봅시다.", "ㅙ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005887/MOV000359889_700X466.mp4", 0, VOWEL),
                new Edu("ㅝ", "ㅝ을 수어로 배워봅시다.", "ㅝ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220727/1001930/MOV000359507_700X466.mp4", 0, VOWEL),
                new Edu("ㅞ", "ㅞ을 수어로 배워봅시다.", "ㅞ", "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005889/MOV000359891_700X466.mp4", 0, VOWEL)

        );

        int insertedCount = 0;

        for (Edu edu : eduList) {
            if (!eduRepository.existsByWord(edu.getWord())) { // 개별 데이터 검사 후 삽입
                eduRepository.save(edu);
                insertedCount++;
            }
        }

        if (insertedCount > 0) {
            System.out.println(insertedCount + "개의 데이터가 추가되었습니다.");
        } else {
            System.out.println("모든 데이터가 이미 존재합니다.");
        }
    }
}

