package com.oysen.servicemap.controller;

import com.oysen.internalcommon.dto.ResponseResult;
import com.oysen.internalcommon.responese.TerminalResponse;
import com.oysen.internalcommon.responese.TrsearchResponse;
import com.oysen.servicemap.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/terminal")
public class TerminalController {

    @Autowired
    private TerminalService terminalService;

    /**
     * 创建/添加终端
     * @param name
     * @return
     */
    @PostMapping("/add")
    public ResponseResult<TerminalResponse> add(String name, String desc) {
        return terminalService.add(name, desc);
    }

    /**
     * 终端搜索
     * @param center
     * @param radius
     * @return
     */
    @PostMapping("/aroundsearch")
    public ResponseResult<List<TerminalResponse>> aroundsearch(String center, Integer radius) {
        return terminalService.aroundsearch(center, radius);
    }

    /**
     * 轨迹查询
     * @param tid
     * @param starttime
     * @param endtime
     * @return
     */
    @PostMapping("/trsearch")
    public ResponseResult<TrsearchResponse> trsearch(String tid, Long starttime, Long endtime) {
        return terminalService.trsearch(tid, starttime, endtime);
    }
}
