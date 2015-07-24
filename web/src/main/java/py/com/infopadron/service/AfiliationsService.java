package py.com.infopadron.service;

import py.com.infopadron.dto.AfiliedDTO;


import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * Created by afeltes on 3/6/14.
 */
public interface AfiliationsService {
  AfiliedDTO findById(Long id);

  List<AfiliedDTO> listAfiliations();

}
