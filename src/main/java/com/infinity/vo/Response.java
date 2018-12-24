package com.infinity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 返回对象
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    private boolean success;    // 处理是否成功
    private String message;
    private Object body;

    public Response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}

