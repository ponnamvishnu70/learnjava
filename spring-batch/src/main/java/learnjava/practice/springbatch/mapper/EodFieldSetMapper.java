package learnjava.practice.springbatch.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import learnjava.practice.springbatch.BaseResourceAware;
import learnjava.practice.springbatch.model.EodData;

public class EodFieldSetMapper implements FieldSetMapper<EodData> {
	
	
	public EodData mapFieldSet(FieldSet fieldSet) throws BindException {
		EodData eodData = new EodData();
	//	DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("M/d/yyyy");
		eodData.setTimeStamp(LocalDate.parse(fieldSet.readString(0)));
		eodData.setOpenPrice(NumberUtils.isCreatable(fieldSet.readString(1))==true ? fieldSet.readDouble(1): 0);
		eodData.setHighPrice(NumberUtils.isCreatable(fieldSet.readString(2))==true ? fieldSet.readDouble(2): 0);
		eodData.setLowPrice(NumberUtils.isCreatable(fieldSet.readString(3))==true ? fieldSet.readDouble(3): 0);
		eodData.setClosePrice(NumberUtils.isCreatable(fieldSet.readString(4))==true ? fieldSet.readDouble(4): 0);
		eodData.setAdjClosePrice(NumberUtils.isCreatable(fieldSet.readString(5))==true ? fieldSet.readDouble(5): 0);
		eodData.setVolume(NumberUtils.isCreatable(fieldSet.readString(6))==true ? fieldSet.readLong(6): 0);
		//eodData.setTicker(fieldSet.readString(7));
		return eodData;
	}

}
