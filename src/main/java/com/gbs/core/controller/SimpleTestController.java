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
@RequestMapping("/v1")
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
                        "path", "/grind-tracker/best-grind-spots",
                        "label", "推荐刷怪点",
                        "imgSrc", "https://assets.garmoth.com/icons/menu/best-grind-spots.png",
                        "imgAlt", "推荐刷怪点图标"
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
                                                "imgSrc", "https://garmoth-assets.oss-cn-shanghai.aliyuncs.com/Productions/boss-timer/kzarka.png",
                                                "imgAlt", "kzarka",
                                                "time", "1724920574",
                                                "bossName", "科扎卡",
                                                "bossColor", "red"
                                        ),
                                        Map.of(
                                                "position", "next",
                                                "title", "下一个Boss",
                                                "imgSrc", "https://garmoth-assets.oss-cn-shanghai.aliyuncs.com/Productions/boss-timer/garmoth.png",
                                                "imgAlt", "garmoth",
                                                "time", "1724920574",
                                                "bossName", "卡莫斯",
                                                "bossColor", "green"
                                        ),
                                        Map.of(
                                                "position", "upcoming",
                                                "title", "接下来是",
                                                "imgSrc", "https://garmoth-assets.oss-cn-shanghai.aliyuncs.com/Productions/boss-timer/karanda.png",
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
                                                "imgSrc", "https://garmoth-assets.oss-cn-shanghai.aliyuncs.com/Productions/boss-timer/garmoth.png",
                                                "imgAlt", "garmoth",
                                                "borderColor", "green",
                                                "className", "cursor-pointer overflow-hidden rounded-full border-2 border-500 bg-800 outline-2 outline outline-green hover:border-green"
                                        ),
                                        Map.of(
                                                "imgSrc", "https://garmoth-assets.oss-cn-shanghai.aliyuncs.com/Productions/boss-timer/karanda.png",
                                                "imgAlt", "karanda",
                                                "borderColor", "green",
                                                "className", "cursor-pointer overflow-hidden rounded-full border-2 border-500 bg-800 outline-2 outline outline-green hover:border-green"
                                        ),
                                        Map.of(
                                                "imgSrc", "https://garmoth-assets.oss-cn-shanghai.aliyuncs.com/Productions/boss-timer/kutum.png",
                                                "imgAlt", "kutum",
                                                "borderColor", "green",
                                                "className", "cursor-pointer overflow-hidden rounded-full border-2 border-500 bg-800 outline-2 outline outline-green hover:border-green"
                                        ),
                                        Map.of(
                                                "imgSrc", "https://garmoth-assets.oss-cn-shanghai.aliyuncs.com/Productions/boss-timer/kzarka.png",
                                                "imgAlt", "kzarka",
                                                "borderColor", "green",
                                                "className", "cursor-pointer overflow-hidden rounded-full border-2 border-500 bg-800 outline-2 outline outline-green hover:border-green"
                                        ),
                                        Map.of(
                                                "imgSrc", "https://garmoth-assets.oss-cn-shanghai.aliyuncs.com/Productions/boss-timer/nouver.png",
                                                "imgAlt", "nouver",
                                                "borderColor", "green",
                                                "className", "cursor-pointer overflow-hidden rounded-full border-2 border-500 bg-800 outline-2 outline outline-green hover:border-green"
                                        ),
                                        Map.of(
                                                "imgSrc", "https://garmoth-assets.oss-cn-shanghai.aliyuncs.com/Productions/boss-timer/quint.png",
                                                "imgAlt", "quint",
                                                "borderColor", "400",
                                                "className", "cursor-pointer overflow-hidden rounded-full border-2 border-500 bg-800 outline-2 opacity-75 hover:border-400"
                                        ),
                                        Map.of(
                                                "imgSrc", "https://garmoth-assets.oss-cn-shanghai.aliyuncs.com/Productions/boss-timer/muraka.png",
                                                "imgAlt", "muraka",
                                                "borderColor", "400",
                                                "className", "cursor-pointer overflow-hidden rounded-full border-2 border-500 bg-800 outline-2 opacity-75 hover:border-400"
                                        ),
                                        Map.of(
                                                "imgSrc", "https://garmoth-assets.oss-cn-shanghai.aliyuncs.com/Productions/boss-timer/offin.png",
                                                "imgAlt", "offin",
                                                "borderColor", "400",
                                                "className", "cursor-pointer overflow-hidden rounded-full border-2 border-500 bg-800 outline-2 opacity-75 hover:border-400"
                                        ),
                                        Map.of(
                                                "imgSrc", "https://garmoth-assets.oss-cn-shanghai.aliyuncs.com/Productions/boss-timer/vell.png",
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
                                Map.of("name", "肯恩特", "color", "yellow", "opacity", 1),
                                Map.of("name", "穆拉卡", "color", "white", "opacity", 1)
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
                        "time", "02:00",
                        "Monday", List.of(
                                Map.of("name", "柯扎卡", "color", "red", "opacity", 1),
                                Map.of("name", "库屯", "color", "purple", "opacity", 1)
                        ),
                        "Tuesday", List.of(
                                Map.of("name", "罗裴勒", "color", "orange", "opacity", 1)
                        ),
                        "Wednesday", List.of(
                                Map.of("name", "卡岚达", "color", "blue", "opacity", 1)
                        ),
                        "Thursday", List.of(
                                Map.of("name", "库屯", "color", "purple", "opacity", 1)
                        ),
                        "Friday", List.of(
                                Map.of("name", "柯扎卡", "color", "red", "opacity", 1),
                                Map.of("name", "罗裴勒", "color", "orange", "opacity", 1)
                        ),
                        "Saturday", List.of(
                                Map.of("name", "柯扎卡", "color", "red", "opacity", 1),
                                Map.of("name", "库屯", "color", "purple", "opacity", 1)
                        ),
                        "Sunday", List.of(
                                Map.of("name", "卡岚达", "color", "blue", "opacity", 1),
                                Map.of("name", "罗裴勒", "color", "orange", "opacity", 1)
                        )
                ),
                Map.of(
                        "time", "11:00",
                        "Monday", List.of(
                                Map.of("name", "卡岚达", "color", "blue", "opacity", 1)
                        ),
                        "Tuesday", List.of(
                                Map.of("name", "柯扎卡", "color", "red", "opacity", 1),
                                Map.of("name", "库屯", "color", "purple", "opacity", 1)
                        ),
                        "Wednesday", List.of(
                                Map.of("name", "柯扎卡", "color", "red", "opacity", 1)
                        ),
                        "Thursday", List.of(
                                Map.of("name", "卡岚达", "color", "blue", "opacity", 1),
                                Map.of("name", "库屯", "color", "purple", "opacity", 1)
                        ),
                        "Friday", List.of(
                                Map.of("name", "库屯", "color", "purple", "opacity", 1)
                        ),
                        "Saturday", List.of(
                                Map.of("name", "卡岚达", "color", "blue", "opacity", 1),
                                Map.of("name", "库屯", "color", "purple", "opacity", 1)
                        ),
                        "Sunday", List.of(
                                Map.of("name", "柯扎卡", "color", "red", "opacity", 1),
                                Map.of("name", "罗裴勒", "color", "orange", "opacity", 1)
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
                        "Sunday", List.of(
                        )
                ),
                Map.of(
                        "time", "15:00",
                        "Monday", List.of(
                                Map.of("name", "柯扎卡", "color", "red", "opacity", 1),
                                Map.of("name", "库屯", "color", "purple", "opacity", 1)
                        ),
                        "Tuesday", List.of(
                                Map.of("name", "卡岚达", "color", "blue", "opacity", 1),
                                Map.of("name", "罗裴勒", "color", "orange", "opacity", 1)
                        ),
                        "Wednesday", List.of(

                        ),
                        "Thursday", List.of(
                                Map.of("name", "柯扎卡", "color", "red", "opacity", 1),
                                Map.of("name", "罗裴勒", "color", "orange", "opacity", 1)
                        ),
                        "Friday", List.of(
                                Map.of("name", "卡岚达", "color", "blue", "opacity", 1),
                                Map.of("name", "罗裴勒", "color", "orange", "opacity", 1)
                        ),
                        "Saturday", List.of(

                        ),
                        "Sunday", List.of(

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
                                Map.of("name", "罗裴勒", "color", "orange", "opacity", 1)
                        ),
                        "Friday", List.of(
                                Map.of("name", "柯扎卡", "color", "red", "opacity", 1),
                                Map.of("name", "库屯", "color", "purple", "opacity", 1)
                        ),
                        "Saturday", List.of(
                                Map.of("name", "柯扎卡", "color", "red", "opacity", 1),
                                Map.of("name", "罗裴勒", "color", "orange", "opacity", 1)
                        ),
                        "Sunday", List.of(
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
                                Map.of("name", "柯扎卡", "color", "red", "opacity", 1),
                                Map.of("name", "库屯", "color", "purple", "opacity", 1)
                        ),
                        "Tuesday", List.of(
                                Map.of("name", "柯扎卡", "color", "red", "opacity", 1),
                                Map.of("name", "罗裴勒", "color", "orange", "opacity", 1)
                        ),
                        "Wednesday", List.of(
                                Map.of("name", "卡岚达", "color", "blue", "opacity", 1)
                        ),
                        "Thursday", List.of(
                                Map.of("name", "卡岚达", "color", "blue", "opacity", 1),
                                Map.of("name", "库屯", "color", "purple", "opacity", 1)
                        ),
                        "Friday", List.of(
                                Map.of("name", "肯恩特", "color", "yellow", "opacity", 1),
                                Map.of("name", "穆拉卡", "color", "white", "opacity", 1)
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
                        "src", "https://garmoth-assets.oss-cn-shanghai.aliyuncs.com/Productions/boss-timer/nouver.png",
                        "alt", "nouver",
                        "name", "罗裴勒"
                ),
                Map.of(
                        "src", "https://garmoth-assets.oss-cn-shanghai.aliyuncs.com/Productions/boss-timer/garmoth.png",
                        "alt", "garmoth",
                        "name", "卡莫斯"
                ),
                Map.of(
                        "src", "https://garmoth-assets.oss-cn-shanghai.aliyuncs.com/Productions/boss-timer/kutum.png",
                        "alt", "kutum",
                        "name", "库屯"
                ),
                Map.of(
                        "src", "https://garmoth-assets.oss-cn-shanghai.aliyuncs.com/Productions/boss-timer/offin.png",
                        "alt", "offin",
                        "name", "奥平"
                ),
                Map.of(
                        "src", "https://garmoth-assets.oss-cn-shanghai.aliyuncs.com/Productions/boss-timer/vell.png",
                        "alt", "vell",
                        "name", "贝尔"
                ),
                Map.of(
                        "src", "https://garmoth-assets.oss-cn-shanghai.aliyuncs.com/Productions/boss-timer/karanda.png",
                        "alt", "karanda",
                        "name", "卡岚达"
                ),
                Map.of(
                        "src", "https://garmoth-assets.oss-cn-shanghai.aliyuncs.com/Productions/boss-timer/kzarka.png",
                        "alt", "kzarka",
                        "name", "柯扎卡"
                ),
                Map.of(
                        "src", "https://garmoth-assets.oss-cn-shanghai.aliyuncs.com/Productions/boss-timer/quint.png",
                        "alt", "quint",
                        "name", "肯恩特"
                ),
                Map.of(
                        "src", "https://garmoth-assets.oss-cn-shanghai.aliyuncs.com/Productions/boss-timer/muraka.png",
                        "alt", "muraka",
                        "name", "穆拉卡"
                )
        );
    }

    @GetMapping("/grindTrackBestSpot")
    public List<Map<String, Object>> getGrindTrackBestSpot() {
        return List.of(
//                Map.of(
//                        "href", "/grind-tracker/global/97",
//                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
//                        "mainImage", Map.of(
//                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044516.webp",
//                                "loading", "lazy",
//                                "lazy", "lazy",
//                                "alt", "",
//                                "className", "item-icon size-10"
//                        ),
//                        "title", "凯品拉西亚寺院(地下)",
//                        "AP", "290攻",
//                        "DP", "380防",
//                        "secondaryImages", List.of(
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/18_belt/00012237.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                ),
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/15_necklace/00011629.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                ),
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/07_productmaterial/00004917.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                ),
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/07_productmaterial/00006393.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                ),
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/09_petitem/00050801.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                )
//                        ),
//                        "price", "7.56亿",
//                        "rating", 3
//                ),
//                Map.of(
//                        "href", "/grind-tracker/global/22",
//                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
//                        "mainImage", Map.of(
//                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044352.webp",
//                                "loading", "lazy",
//                                "lazy", "lazy",
//                                "alt", "",
//                                "className", "item-icon size-10"
//                        ),
//                        "title", "血狼部落",
//                        "AP", "180攻",
//                        "DP", "210防",
//                        "secondaryImages", List.of(
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/11_enchant_material/00015668.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                ),
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040760.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                ),
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040710.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                ),
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/16_ring/00012048.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                ),
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/11_enchant_material/00721044.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                ),
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/09_upperbody/00014082.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                ),
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040351.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                )
//                        ),
//                        "price", "6.05亿",
//                        "rating", 2
//                ),
//                Map.of(
//                        "href", "/grind-tracker/global/119",
//                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
//                        "mainImage", Map.of(
//                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044354.webp",
//                                "loading", "lazy",
//                                "lazy", "lazy",
//                                "alt", "",
//                                "className", "item-icon size-10"
//                        ),
//                        "title", "谢雷坎之墓(夜晚)",
//                        "AP", "210攻",
//                        "DP", "230防",
//                        "secondaryImages", List.of(
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040762.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                ),
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040706.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                ),
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/11_enchant_material/00721044.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                ),
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/18_belt/00012251.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                )
//                        ),
//                        "price", "5.45亿",
//                        "rating", 2
//                ),


        Map.of(
                        "href", "/grind-tracker/global/1",
                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
                        "mainImage", Map.of(
                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044380.webp",
                                "loading", "lazy",
                                "lazy", "lazy",
                                "alt", "",
                                "className", "item-icon size-10"
                        ),
                        "title", "希克莱亚海底遗迹(深层)",
                        "AP", "240攻",
                        "DP", "330防",
                        "secondaryImages", List.of(
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/16_ring/00012061.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044383.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044268.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                )
                        ),
                        "price", "5.03亿",
                        "rating", 2
                ),

//                Map.of(
//                        "href", "/grind-tracker/global/24",
//                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
//                        "mainImage", Map.of(
//                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044353.webp",
//                                "loading", "lazy",
//                                "lazy", "lazy",
//                                "alt", "",
//                                "className", "item-icon size-10"
//                        ),
//                        "title", "特斯拉废墟",
//                        "AP", "140攻",
//                        "DP", "160防",
//                        "secondaryImages", List.of(
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040752.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                ),
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040711.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                ),
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/16_ring/00012048.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                ),
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/11_enchant_material/00721044.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                ),
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040351.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                )
//                        ),
//                        "price", "4.87亿",
//                        "rating", 2
//                ),
                Map.of(
                        "href", "/grind-tracker/global/25",
                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
                        "mainImage", Map.of(
                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044302.webp",
                                "loading", "lazy",
                                "lazy", "lazy",
                                "alt", "",
                                "className", "item-icon size-10"
                        ),
                        "title", "蔓沙姆森林",
                        "AP", "190攻",
                        "DP", "260防",
                        "secondaryImages", List.of(
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040757.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040708.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/07_productmaterial/00004917.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/17_earring/00011834.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/11_enchant_material/00721044.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040351.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                )
                        ),
                        "price", "4.66亿",
                        "rating", 2
                ),
//                Map.of(
//                        "href", "/grind-tracker/global/23",
//                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
//                        "mainImage", Map.of(
//                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044363.webp",
//                                "loading", "lazy",
//                                "lazy", "lazy",
//                                "alt", "",
//                                "className", "item-icon size-10"
//                        ),
//                        "title", "谢雷坎之墓(白天)",
//                        "AP", "190攻",
//                        "DP", "230防",
//                        "secondaryImages", List.of(
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040762.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                ),
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040706.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                ),
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/18_belt/00012251.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                ),
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/11_enchant_material/00721044.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                ),
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040351.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                )
//                        ),
//                        "price", "4.64亿",
//                        "rating", 2
//                ),
        Map.of(
                        "href", "/grind-tracker/global/37",
                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
                        "mainImage", Map.of(
                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044378.webp",
                                "loading", "lazy",
                                "lazy", "lazy",
                                "alt", "",
                                "className", "item-icon size-10"
                        ),
                        "title", "普罗提洞穴",
                        "AP", "170攻",
                        "DP", "200防",
                        "secondaryImages", List.of(
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/16_ring/00012061.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/16_ring/00012045.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044383.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040351.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                )
                        ),
                        "price", "4.62亿",
                        "rating", 2
                ),
                Map.of(
                        "href", "/grind-tracker/global/26",
                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
                        "mainImage", Map.of(
                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044323.webp",
                                "loading", "lazy",
                                "lazy", "lazy",
                                "alt", "",
                                "className", "item-icon size-10"
                        ),
                        "title", "森林罗纳罗斯地区",
                        "AP", "190攻",
                        "DP", "270防",
                        "secondaryImages", List.of(
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040758.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040709.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/07_productmaterial/00004917.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/16_ring/00012042.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/11_enchant_material/00721044.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/09_petitem/00050801.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040351.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                )
                        ),
                        "price", "4.47亿",
                        "rating", 2
                ),
//                Map.of(
//                        "href", "/grind-tracker/global/9",
//                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
//                        "mainImage", Map.of(
//                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044423.webp",
//                                "loading", "lazy",
//                                "lazy", "lazy",
//                                "alt", "",
//                                "className", "item-icon size-10"
//                        ),
//                        "title", "克拉图卡古代遗迹",
//                        "AP", "230攻",
//                        "DP", "300防",
//                        "secondaryImages", List.of(
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/17_earring/00011828.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                ),
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/07_productmaterial/00006393.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                ),
//                                Map.of(
//                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/15_necklace/00011630.webp",
//                                        "loading", "lazy",
//                                        "lazy", "lazy",
//                                        "alt", "",
//                                        "className", "item-icon size-8"
//                                )
//                        ),
//                        "price", "4.47亿",
//                        "rating", 2
//                ),
                Map.of(
                        "href", "/grind-tracker/global/29",
                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
                        "mainImage", Map.of(
                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044322.webp",
                                "loading", "lazy",
                                "lazy", "lazy",
                                "alt", "",
                                "className", "item-icon size-10"
                        ),
                        "title", "波黎之森",
                        "AP", "140攻",
                        "DP", "250防",
                        "secondaryImages", List.of(
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/11_enchant_material/00721044.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/09_upperbody/00014082.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040351.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                )
                        ),
                        "price", "4.36亿",
                        "rating", 2
                ),
                Map.of(
                        "href", "/grind-tracker/global/33",
                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
                        "mainImage", Map.of(
                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044324.webp",
                                "loading", "lazy",
                                "lazy", "lazy",
                                "alt", "",
                                "className", "item-icon size-10"
                        ),
                        "title", "盖芬拉西亚寺院（地上）",
                        "AP", "250攻",
                        "DP", "320防",
                        "secondaryImages", List.of(
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/07_productmaterial/00004917.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/18_belt/00012237.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/09_petitem/00050801.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                )
                        ),
                        "price", "4.24亿",
                        "rating", 2
                ),
                Map.of(
                        "href", "/grind-tracker/global/38",
                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
                        "mainImage", Map.of(
                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044321.webp",
                                "loading", "lazy",
                                "lazy", "lazy",
                                "alt", "",
                                "className", "item-icon size-10"
                        ),
                        "title", "帕多斯聚集地",
                        "AP", "120攻",
                        "DP", "180防",
                        "secondaryImages", List.of(
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/07_productmaterial/00004917.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/11_enchant_material/00721044.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040351.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                )
                        ),
                        "price", "4.02亿",
                        "rating", 2
                ),
                Map.of(
                        "href", "/grind-tracker/global/28",
                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
                        "mainImage", Map.of(
                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044303.webp",
                                "loading", "lazy",
                                "lazy", "lazy",
                                "alt", "",
                                "className", "item-icon size-10"
                        ),
                        "title", "米路慕遗址",
                        "AP", "190攻",
                        "DP", "270防",
                        "secondaryImages", List.of(
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/07_productmaterial/00004917.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/18_belt/00012236.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/09_petitem/00050801.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                )
                        ),
                        "price", "3.85亿",
                        "rating", 2
                ),
                Map.of(
                        "href", "/grind-tracker/global/90",
                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
                        "mainImage", Map.of(
                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044215.webp",
                                "loading", "lazy",
                                "lazy", "lazy",
                                "alt", "",
                                "className", "item-icon size-10"
                        ),
                        "title", "半人马群落",
                        "AP", "180攻",
                        "DP", "200防",
                        "secondaryImages", List.of(
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/18_belt/00012229.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040351.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                )
                        ),
                        "price", "3.57亿",
                        "rating", 1
                ),
                // 继续添加剩余的数据项
                Map.of(
                        "href", "/grind-tracker/global/83",
                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
                        "mainImage", Map.of(
                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044217.webp",
                                "loading", "lazy",
                                "lazy", "lazy",
                                "alt", "",
                                "className", "item-icon size-10"
                        ),
                        "title", "狄狄恩溪谷",
                        "AP", "100攻",
                        "DP", "180防",
                        "secondaryImages", List.of(
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/15_necklace/00011628.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040351.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                )
                        ),
                        "price", "3.49亿",
                        "rating", 1
                ),
                Map.of(
                        "href", "/grind-tracker/global/85",
                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
                        "mainImage", Map.of(
                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044218.webp",
                                "loading", "lazy",
                                "lazy", "lazy",
                                "alt", "",
                                "className", "item-icon size-10"
                        ),
                        "title", "新月神殿",
                        "AP", "140攻",
                        "DP", "160防",
                        "secondaryImages", List.of(
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/16_ring/00012031.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040351.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                )
                        ),
                        "price", "3.45亿",
                        "rating", 1
                ),
                Map.of(
                        "href", "/grind-tracker/global/86",
                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
                        "mainImage", Map.of(
                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044214.webp",
                                "loading", "lazy",
                                "lazy", "lazy",
                                "alt", "",
                                "className", "item-icon size-10"
                        ),
                        "title", "卡德里废墟",
                        "AP", "140攻",
                        "DP", "160防",
                        "secondaryImages", List.of(
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/16_ring/00012032.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/15_necklace/00011628.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040351.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                )
                        ),
                        "price", "3.42亿",
                        "rating", 1
                ),
                Map.of(
                        "href", "/grind-tracker/global/6",
                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
                        "mainImage", Map.of(
                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044266.webp",
                                "loading", "lazy",
                                "lazy", "lazy",
                                "alt", "",
                                "className", "item-icon size-10"
                        ),
                        "title", "亚克曼",
                        "AP", "230攻",
                        "DP", "300防",
                        "secondaryImages", List.of(
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/17_earring/00011828.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                )
                        ),
                        "price", "3.38亿",
                        "rating", 1
                ),
                Map.of(
                        "href", "/grind-tracker/global/11",
                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
                        "mainImage", Map.of(
                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044446.webp",
                                "loading", "lazy",
                                "lazy", "lazy",
                                "alt", "",
                                "className", "item-icon size-10"
                        ),
                        "title", "被遗弃修道院（禁域）",
                        "AP", "260攻",
                        "DP", "350防",
                        "secondaryImages", List.of(
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/17_earring/00011855.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                )
                        ),
                        "price", "3.23亿",
                        "rating", 1
                ),
                Map.of(
                        "href", "/grind-tracker/global/3",
                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
                        "mainImage", Map.of(
                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044267.webp",
                                "loading", "lazy",
                                "lazy", "lazy",
                                "alt", "",
                                "className", "item-icon size-10"
                        ),
                        "title", "赫斯特里亚废墟",
                        "AP", "230攻",
                        "DP", "300防",
                        "secondaryImages", List.of(
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/17_earring/00011828.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/15_necklace/00011629.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                )
                        ),
                        "price", "3.20亿",
                        "rating", 1
                ),
                // 继续在您的方法中添加剩余的数据项
                Map.of(
                        "href", "/grind-tracker/global/43",
                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
                        "mainImage", Map.of(
                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044220.webp",
                                "loading", "lazy",
                                "lazy", "lazy",
                                "alt", "",
                                "className", "item-icon size-10"
                        ),
                        "title", "伽哈兹猎者团巢穴",
                        "AP", "140攻",
                        "DP", "180防",
                        "secondaryImages", List.of(
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/15_necklace/00011628.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040351.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                )
                        ),
                        "price", "2.87亿",
                        "rating", 1
                ),
                Map.of(
                        "href", "/grind-tracker/global/82",
                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
                        "mainImage", Map.of(
                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044219.webp",
                                "loading", "lazy",
                                "lazy", "lazy",
                                "alt", "",
                                "className", "item-icon size-10"
                        ),
                        "title", "沙漠纳迦圣殿",
                        "AP", "100攻",
                        "DP", "180防",
                        "secondaryImages", List.of(
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/15_necklace/00011628.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040351.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                )
                        ),
                        "price", "2.75亿",
                        "rating", 1
                ),
                Map.of(
                        "href", "/grind-tracker/global/84",
                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
                        "mainImage", Map.of(
                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044212.webp",
                                "loading", "lazy",
                                "lazy", "lazy",
                                "alt", "",
                                "className", "item-icon size-10"
                        ),
                        "title", "巴西恩族营地",
                        "AP", "100攻",
                        "DP", "180防",
                        "secondaryImages", List.of(
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040351.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                )
                        ),
                        "price", "2.65亿",
                        "rating", 1
                ),
                Map.of(
                        "href", "/grind-tracker/global/32",
                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
                        "mainImage", Map.of(
                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044382.webp",
                                "loading", "lazy",
                                "lazy", "lazy",
                                "alt", "",
                                "className", "item-icon size-10"
                        ),
                        "title", "希克莱亚海底遗迹(上层)",
                        "AP", "200攻",
                        "DP", "260防",
                        "secondaryImages", List.of(
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/16_ring/00012061.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044383.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044268.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040351.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                )
                        ),
                        "price", "2.61亿",
                        "rating", 1
                ),
                Map.of(
                        "href", "/grind-tracker/global/92",
                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
                        "mainImage", Map.of(
                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044265.webp",
                                "loading", "lazy",
                                "lazy", "lazy",
                                "alt", "",
                                "className", "item-icon size-10"
                        ),
                        "title", "匹拉·酷监狱",
                        "AP", "190攻",
                        "DP", "240防",
                        "secondaryImages", List.of(
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/15_necklace/00011625.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040351.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                )
                        ),
                        "price", "1.85亿",
                        "rating", 1
                ),
                Map.of(
                        "href", "/grind-tracker/global/91",
                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
                        "mainImage", Map.of(
                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044264.webp",
                                "loading", "lazy",
                                "lazy", "lazy",
                                "alt", "",
                                "className", "item-icon size-10"
                        ),
                        "title", "路德硫磺矿山",
                        "AP", "190攻",
                        "DP", "240防",
                        "secondaryImages", List.of(
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/15_necklace/00011625.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/09_upperbody/00014082.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040351.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                )
                        ),
                        "price", "1.77亿",
                        "rating", 1
                ),
                Map.of(
                        "href", "/grind-tracker/global/34",
                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
                        "mainImage", Map.of(
                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044180.webp",
                                "loading", "lazy",
                                "lazy", "lazy",
                                "alt", "",
                                "className", "item-icon size-10"
                        ),
                        "title", "秀兹近卫队",
                        "AP", "210攻",
                        "DP", "320防",
                        "secondaryImages", List.of(
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/15_necklace/00011631.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                )
                        ),
                        "price", "1.33亿",
                        "rating", 1
                ),
                Map.of(
                        "href", "/grind-tracker/global/39",
                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
                        "mainImage", Map.of(
                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044300.webp",
                                "loading", "lazy",
                                "lazy", "lazy",
                                "alt", "",
                                "className", "item-icon size-10"
                        ),
                        "title", "纳班草原",
                        "AP", "190攻",
                        "DP", "260防",
                        "secondaryImages", List.of(
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044300.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                )
                        ),
                        "price", "0.94亿",
                        "rating", 1
                ),
                Map.of(
                        "href", "/grind-tracker/global/88",
                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
                        "mainImage", Map.of(
                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044216.webp",
                                "loading", "lazy",
                                "lazy", "lazy",
                                "alt", "",
                                "className", "item-icon size-10"
                        ),
                        "title", "沃拉坤巢穴",
                        "AP", "150攻",
                        "DP", "220防",
                        "secondaryImages", List.of(
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/15_necklace/00011628.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                )
                        ),
                        "price", "0.90亿",
                        "rating", 1
                ),
                Map.of(
                        "href", "/grind-tracker/global/89",
                        "className", "opacity-100 flex cursor-pointer flex-col gap-3 rounded-md border border-600 bg-700 p-1 transition-all hover:border-500 hover:brightness-110 lg:flex-row",
                        "mainImage", Map.of(
                                "src", "https://assets.garmoth.com/img/new_icon/03_etc/04_dropitem/00044213.webp",
                                "loading", "lazy",
                                "lazy", "lazy",
                                "alt", "",
                                "className", "item-icon size-10"
                        ),
                        "title", "蛇怪巢穴",
                        "AP", "180攻",
                        "DP", "220防",
                        "secondaryImages", List.of(
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/06_pc_equipitem/00_common/18_belt/00012230.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                ),
                                Map.of(
                                        "src", "https://assets.garmoth.com/img/new_icon/03_etc/03_quest_item/00040351.webp",
                                        "loading", "lazy",
                                        "lazy", "lazy",
                                        "alt", "",
                                        "className", "item-icon size-8"
                                )
                        ),
                        "price", "0.57亿",
                        "rating", 1
                )

        );
    }


}
