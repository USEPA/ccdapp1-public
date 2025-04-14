package gov.epa.ccte.api.ccdapp1.pgsql.repository;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.QmrfData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import io.swagger.v3.oas.annotations.Hidden;

@RepositoryRestResource(exported = false)
public interface QmrfDataRepository extends JpaRepository<QmrfData, String> {


    QmrfData findByModelId(int modelId);

    @Override
    @Hidden
    @RestResource(exported = false)
    <S extends QmrfData> S save(S s);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteById(String s);

    @Override
    @Hidden
    @RestResource(exported = false)
    void delete(QmrfData qmrfData);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends QmrfData> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll();
}