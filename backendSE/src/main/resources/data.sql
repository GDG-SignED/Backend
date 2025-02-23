-- 🎯 중복 삽입 방지 (기존 데이터 삭제 후 삽입)
DELETE FROM edu;

-- 🎯 초기 데이터 삽입
INSERT INTO edu (category, content, title, video_url, views, word) VALUES
                                                                       ('CONSONANT', 'ㄱ을 수어로 배워봅시다.', 'ㄱ', 'http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005695/MOV000359820_320X240.mp4', 0, 'ㄱ'),
                                                                       ('CONSONANT', 'ㄴ을 수어로 배워봅시다.', 'ㄴ', 'http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220811/1009739/MOV000360036_320X240.mp4', 0, 'ㄴ'),
                                                                       ('CONSONANT', 'ㄷ을 수어로 배워봅시다.', 'ㄷ', 'http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220811/1009752/MOV000360049_320X240.mp4', 0, 'ㄷ'),
                                                                       ('CONSONANT', 'ㄹ을 수어로 배워봅시다.', 'ㄹ', 'http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005858/MOV000359860_320X240.mp4', 0, 'ㄹ'),
                                                                       ('CONSONANT', 'ㅁ을 수어로 배워봅시다.', 'ㅁ', 'http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220811/1009748/MOV000360045_320X240.mp4', 0, 'ㅁ'),
                                                                       ('CONSONANT', 'ㅂ을 수어로 배워봅시다.', 'ㅂ', 'http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220803/1006271/MOV000359919_320X240.mp4', 0, 'ㅂ'),
                                                                       ('CONSONANT', 'ㅅ을 수어로 배워봅시다.', 'ㅅ', 'http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005893/MOV000359895_320X240.mp4', 0, 'ㅅ'),
                                                                       ('CONSONANT', 'ㅇ을 수어로 배워봅시다.', 'ㅇ', 'http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220811/1009745/MOV000360042_320X240.mp4', 0, 'ㅇ'),
                                                                       ('CONSONANT', 'ㅈ을 수어로 배워봅시다.', 'ㅈ', 'http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220727/1001950/MOV000359527_320X240.mp4', 0, 'ㅈ'),
                                                                       ('CONSONANT', 'ㅊ을 수어로 배워봅시다.', 'ㅊ', 'http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005761/MOV000359838_320X240.mp4', 0, 'ㅊ'),
                                                                       ('VOWEL', 'ㅏ을 수어로 배워봅시다.', 'ㅏ', 'http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005855/MOV000359857_320X240.mp4', 0, 'ㅏ'),
                                                                       ('VOWEL', 'ㅑ을 수어로 배워봅시다.', 'ㅑ', 'http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005755/MOV000359832_320X240.mp4', 0, 'ㅑ'),
                                                                       ('VOWEL', 'ㅓ을 수어로 배워봅시다.', 'ㅓ', 'http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005757/MOV000359834_320X240.mp4', 0, 'ㅓ'),
                                                                       ('VOWEL', 'ㅕ을 수어로 배워봅시다.', 'ㅕ', 'http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005884/MOV000359886_320X240.mp4', 0, 'ㅕ'),
                                                                       ('VOWEL', 'ㅗ을 수어로 배워봅시다.', 'ㅗ', 'http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005885/MOV000359887_320X240.mp4', 0, 'ㅗ'),
                                                                       ('VOWEL', 'ㅛ을 수어로 배워봅시다.', 'ㅛ', 'http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005888/MOV000359890_320X240.mp4', 0, 'ㅛ'),
                                                                       ('VOWEL', 'ㅜ을 수어로 배워봅시다.', 'ㅜ', 'http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220727/1001927/MOV000359504_320X240.mp4', 0, 'ㅜ'),
                                                                       ('VOWEL', 'ㅠ을 수어로 배워봅시다.', 'ㅠ', 'http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220811/1009753/MOV000360050_320X240.mp4', 0, 'ㅠ'),
                                                                       ('VOWEL', 'ㅡ을 수어로 배워봅시다.', 'ㅡ', 'http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220802/1005890/MOV000359892_320X240.mp4', 0, 'ㅡ'),
                                                                       ('VOWEL', 'ㅣ을 수어로 배워봅시다.', 'ㅣ', 'http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20220811/1009678/MOV000359988_320X240.mp4', 0, 'ㅣ');

