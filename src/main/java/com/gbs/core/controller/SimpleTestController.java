package com.gbs.core.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Map;

@Log4j2
@RestController
@RequestMapping("/api")
public class SimpleTestController {

    @GetMapping("/topMenu")
    public List<Map<String, String>> getTopMenu() {
        return List.of(
                Map.of(
                        "path", "/boss-timer",
                        "label", "世界王时间表",
                        "imgSrc", "https://assets.garmoth.com/icons/menu/boss-timer.png",
                        "imgAlt", "卡普拉石计算器图标"
                ),
                Map.of(
                        "path", "/#",
                        "label", "【即将推出】推荐刷怪点",
                        "imgSrc", "https://assets.garmoth.com/icons/menu/best-grind-spots.png",
                        "imgAlt", "推荐刷怪点图标",
                        "disabled", "true"
                ),
                Map.of(
                        "path", "/#",
                        "label", "【即将推出】刷怪时薪统计",
                        "imgSrc", "https://assets.garmoth.com/icons/menu/global-grind.png",
                        "imgAlt", "刷怪时薪统计图标",
                        "disabled", "true"
                ),
                Map.of(
                        "path", "/#",
                        "label", "【即将推出】美容相册",
                        "imgSrc", "https://assets.garmoth.com/icons/menu/beauty-album.png",
                        "imgAlt", "美容相册图标",
                        "disabled", "true"
                )
        );
    }

    @GetMapping("/bossTimer")
    public Map<String, Object> getBossTimer() {
        return Map.of(
                "title", "Boss时间表",
                "sections", List.of(
                        Map.of(
                                "type", "boss-timers",
                                "bosses", List.of(
                                        Map.of(
                                                "position", "previous",
                                                "title", "上一个Boss",
                                                "imgSrc", "https://assets.garmoth.com/boss/large/kzarka.webp",
                                                "imgAlt", "kzarka",
                                                "time", "1724920574",
                                                "bossName", "科扎卡",
                                                "bossColor", "red"
                                        ),
                                        Map.of(
                                                "position", "next",
                                                "title", "下一个Boss",
                                                "imgSrc", "https://assets.garmoth.com/boss/large/garmoth.webp",
                                                "imgAlt", "garmoth",
                                                "time", "1724920574",
                                                "bossName", "卡莫斯",
                                                "bossColor", "green"
                                        ),
                                        Map.of(
                                                "position", "upcoming",
                                                "title", "接下来是",
                                                "imgSrc", "https://assets.garmoth.com/boss/large/karanda.webp",
                                                "imgAlt", "karanda",
                                                "time", "1724920574",
                                                "bossName", "卡兰达",
                                                "bossColor", "blue"
                                        )
                                )
                        ),
                        Map.of(
                                "type", "settings",
                                "bossIcons", List.of(
                                        Map.of(
                                                "imgSrc", "https://assets.garmoth.com/boss/large/garmoth.webp",
                                                "imgAlt", "garmoth",
                                                "borderColor", "green",
                                                "className", "cursor-pointer overflow-hidden rounded-full border-2 border-500 bg-800 outline-2 outline outline-green hover:border-green"
                                        ),
                                        Map.of(
                                                "imgSrc", "https://assets.garmoth.com/boss/large/karanda.webp",
                                                "imgAlt", "karanda",
                                                "borderColor", "green",
                                                "className", "cursor-pointer overflow-hidden rounded-full border-2 border-500 bg-800 outline-2 outline outline-green hover:border-green"
                                        ),
                                        Map.of(
                                                "imgSrc", "https://assets.garmoth.com/boss/large/kutum.webp",
                                                "imgAlt", "kutum",
                                                "borderColor", "green",
                                                "className", "cursor-pointer overflow-hidden rounded-full border-2 border-500 bg-800 outline-2 outline outline-green hover:border-green"
                                        ),
                                        Map.of(
                                                "imgSrc", "https://assets.garmoth.com/boss/large/kzarka.webp",
                                                "imgAlt", "kzarka",
                                                "borderColor", "green",
                                                "className", "cursor-pointer overflow-hidden rounded-full border-2 border-500 bg-800 outline-2 outline outline-green hover:border-green"
                                        ),
                                        Map.of(
                                                "imgSrc", "https://assets.garmoth.com/boss/large/nouver.webp",
                                                "imgAlt", "nouver",
                                                "borderColor", "green",
                                                "className", "cursor-pointer overflow-hidden rounded-full border-2 border-500 bg-800 outline-2 outline outline-green hover:border-green"
                                        ),
                                        Map.of(
                                                "imgSrc", "https://assets.garmoth.com/boss/large/quint.webp",
                                                "imgAlt", "quint",
                                                "borderColor", "400",
                                                "className", "cursor-pointer overflow-hidden rounded-full border-2 border-500 bg-800 outline-2 opacity-75 hover:border-400"
                                        ),
                                        Map.of(
                                                "imgSrc", "https://assets.garmoth.com/boss/large/muraka.webp",
                                                "imgAlt", "muraka",
                                                "borderColor", "400",
                                                "className", "cursor-pointer overflow-hidden rounded-full border-2 border-500 bg-800 outline-2 opacity-75 hover:border-400"
                                        ),
                                        Map.of(
                                                "imgSrc", "https://assets.garmoth.com/boss/large/offin.webp",
                                                "imgAlt", "offin",
                                                "borderColor", "400",
                                                "className", "cursor-pointer overflow-hidden rounded-full border-2 border-500 bg-800 outline-2 opacity-75 hover:border-400"
                                        ),
                                        Map.of(
                                                "imgSrc", "https://assets.garmoth.com/boss/large/vell.webp",
                                                "imgAlt", "vell",
                                                "borderColor", "green",
                                                "className", "cursor-pointer overflow-hidden rounded-full border-2 border-500 bg-800 outline-2 outline outline-green hover:border-green"
                                        )
                                )
                        )
                )
        );
    }

    @GetMapping("/bossTimerTable")
    public List<Map<String, Object>> getBossTimerTable() {
        return List.of(
                Map.of(
                        "time", "00:15",
                        "Monday", List.of(
                        ),
                        "Tuesday", List.of(
                        ),
                        "Wednesday", List.of(
                        ),
                        "Thursday", List.of(
                        ),
                        "Friday", List.of(
                        ),
                        "Saturday", List.of(
                        ),
                        "周日", List.of(
                        )
                ),
                Map.of(
                        "time", "02:00",
                        "Monday", List.of(
                                Map.of("name", "柯扎卡", "color", "red", "opacity", 1)
                        ),
                        "Tuesday", List.of(
                        ),
                        "Wednesday", List.of(
                                Map.of("name", "卡岚达", "color", "blue", "opacity", 1)
                        ),
                        "Thursday", List.of(
                        ),
                        "Friday", List.of(
                                Map.of("name", "柯扎卡", "color", "red", "opacity", 1)
                        ),
                        "Saturday", List.of(
                                Map.of("name", "柯扎卡", "color", "red", "opacity", 1)
                        ),
                        "周日", List.of(
                                Map.of("name", "卡岚达", "color", "blue", "opacity", 1)
                        )
                ),
                Map.of(
                        "time", "11:00",
                        "Monday", List.of(
                                Map.of("name", "卡岚达", "color", "blue", "opacity", 1)
                        ),
                        "Tuesday", List.of(
                                Map.of("name", "柯扎卡", "color", "red", "opacity", 1)
                        ),
                        "Wednesday", List.of(
                                Map.of("name", "柯扎卡", "color", "red", "opacity", 1)
                        ),
                        "Thursday", List.of(
                                Map.of("name", "卡岚达", "color", "blue", "opacity", 1)
                        ),
                        "Friday", List.of(

                        ),
                        "Saturday", List.of(
                                Map.of("name", "卡岚达", "color", "blue", "opacity", 1)
                        ),
                        "周日", List.of(
                                Map.of("name", "柯扎卡", "color", "red", "opacity", 1)
                        )
                ),
                Map.of(
                        "time", "14:00",
                        "Monday", List.of(
                        ),
                        "Tuesday", List.of(
                        ),
                        "Wednesday", List.of(
                        ),
                        "Thursday", List.of(
                        ),
                        "Friday", List.of(
                        ),
                        "Saturday", List.of(
                        ),
                        "周日", List.of(
                        )
                ),
                Map.of(
                        "time", "15:00",
                        "Monday", List.of(
                                Map.of("name", "柯扎卡", "color", "red", "opacity", 1)
                        ),
                        "Tuesday", List.of(
                                Map.of("name", "卡岚达", "color", "blue", "opacity", 1)
                        ),
                        "Wednesday", List.of(

                        ),
                        "Thursday", List.of(
                                Map.of("name", "柯扎卡", "color", "red", "opacity", 1)
                        ),
                        "Friday", List.of(
                                Map.of("name", "卡岚达", "color", "blue", "opacity", 1)
                        ),
                        "Saturday", List.of(

                        ),
                        "周日", List.of(

                        )
                ),
                Map.of(
                        "time", "19:00",
                        "Monday", List.of(

                        ),
                        "Tuesday", List.of(

                        ),
                        "Wednesday", List.of(
                                Map.of("name", "柯扎卡", "color", "red", "opacity", 1)
                        ),
                        "Thursday", List.of(

                        ),
                        "Friday", List.of(
                                Map.of("name", "柯扎卡", "color", "red", "opacity", 1)
                        ),
                        "Saturday", List.of(
                                Map.of("name", "柯扎卡", "color", "red", "opacity", 1)
                        ),
                        "周日", List.of(
                                Map.of("name", "卡岚达", "color", "blue", "opacity", 1)
                        )
                ),
                Map.of(
                        "time", "22:30",
                        "Monday", List.of(
                        ),
                        "Tuesday", List.of(
                        ),
                        "Wednesday", List.of(
                        ),
                        "Thursday", List.of(
                        ),
                        "Friday", List.of(
                        ),
                        "Saturday", List.of(
                        ),
                        "Sunday", List.of(
                        )
                ),
                Map.of(
                        "time", "23:30",
                        "Monday", List.of(
                                Map.of("name", "柯扎卡", "color", "red", "opacity", 1)
                        ),
                        "Tuesday", List.of(
                                Map.of("name", "柯扎卡", "color", "red", "opacity", 1)
                        ),
                        "Wednesday", List.of(
                                Map.of("name", "卡岚达", "color", "blue", "opacity", 1)
                        ),
                        "Thursday", List.of(
                                Map.of("name", "卡岚达", "color", "blue", "opacity", 1)
                        ),
                        "Friday", List.of(
                        ),
                        "Saturday", List.of(
                        ),
                        "Sunday", List.of(
                        )
                )
        );
    }

    @GetMapping("/bossImage")
    public List<Map<String, Object>> getBossImages() {
        return List.of(
                Map.of(
                        "src", "https://assets.garmoth.com/boss/large/nouver.webp",
                        "alt", "nouver",
                        "name", "罗裴勒"
                ),
                Map.of(
                        "src", "https://assets.garmoth.com/boss/large/garmoth.webp",
                        "alt", "garmoth",
                        "name", "卡莫斯"
                ),
                Map.of(
                        "src", "https://assets.garmoth.com/boss/large/kutum.webp",
                        "alt", "kutum",
                        "name", "库屯"
                ),
                Map.of(
                        "src", "https://assets.garmoth.com/boss/large/offin.webp",
                        "alt", "offin",
                        "name", "奥平"
                ),
                Map.of(
                        "src", "https://assets.garmoth.com/boss/large/vell.webp",
                        "alt", "vell",
                        "name", "贝尔"
                ),
                Map.of(
                        "src", "https://assets.garmoth.com/boss/large/karanda.webp",
                        "alt", "karanda",
                        "name", "卡岚达"
                ),
                Map.of(
                        "src", "https://assets.garmoth.com/boss/large/kzarka.webp",
                        "alt", "kzarka",
                        "name", "柯价卡"
                ),
                Map.of(
                        "src", "https://assets.garmoth.com/boss/large/quint.webp",
                        "alt", "quint",
                        "name", "肯恩特"
                ),
                Map.of(
                        "src", "https://assets.garmoth.com/boss/large/muraka.webp",
                        "alt", "muraka",
                        "name", "穆拉卡"
                )
        );
    }

}
