/**
 * @author leezan
 * @Data 2024/11/25 15:48
 */
package cc.lz.elasticsearchdata.domain.repository.dao;

import cc.lz.elasticsearchdata.domain.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
