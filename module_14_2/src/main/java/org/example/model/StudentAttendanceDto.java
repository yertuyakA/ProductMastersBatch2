package org.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class StudentAttendanceDto {
    private String name;
    private String groupName;
    private boolean isAttended;
}
