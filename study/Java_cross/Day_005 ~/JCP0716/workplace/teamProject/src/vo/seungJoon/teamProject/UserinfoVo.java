package vo.seungJoon.teamProject;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserinfoVo {
	private String id;
	private String password;
	private String phone;
	private String name;
	private Date input_date;
	
}
