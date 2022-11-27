package Movie.movie.business.concretes;

import Movie.movie.business.abstracts.LinkService;
import Movie.movie.core.utilities.constants.CONSTANTS;
import Movie.movie.core.utilities.results.*;
import Movie.movie.dataaccess.LinkDao;
import Movie.movie.entities.Link;
import Movie.movie.entities.dtos.LinkDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkManager implements LinkService {
    private LinkDao linkDao;
    private final ModelMapper modelMapper;
    @Autowired
    public LinkManager(LinkDao linkDao, ModelMapper modelMapper) {
        this.linkDao = linkDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(LinkDto entity) {
        if (entity.getLinkAddress().isEmpty()) {
            return new ErrorResult(CONSTANTS.LINK_NOT_ADD);
        }
        Link link = modelMapper.map(entity,Link.class);
        linkDao.save(link);
        return new SuccessResult(CONSTANTS.LINK_ADD_SUCCESSFULLY);
    }

    @Override
    public Result delete(int id) {
        Link link = this.linkDao.findById(id).get();
        if (link.getLinkAddress().isEmpty()) {
            return new ErrorResult(CONSTANTS.LINK_NOT_DELETE);
        }
        this.linkDao.delete(link);
        return new SuccessResult(CONSTANTS.LINK_DELETE_SUCCESSFULLY);
    }

    @Override
    public Result update(LinkDto entity) {
        if (entity.getLinkAddress().length() < 10) {
            return new ErrorResult(CONSTANTS.LINK_NOT_UPDATE);
        }
        Link link = modelMapper.map(entity,Link.class);
        linkDao.save(link);
        return new SuccessResult(CONSTANTS.LINK_UPDATE_SUCCESSFULLY);
    }

    @Override
    public DataResult getById(int id) {
        Link link = linkDao.findById(id).orElse(null);
        return link.getLinkAddress().isEmpty() ?
                new ErrorDataResult(CONSTANTS.LINK_NOT_FOUND) :
                new SuccessDataResult(link, CONSTANTS.LINK_GET_SUCCESSFULLY);
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.linkDao.findAll(), CONSTANTS.LINK_GET_ALL_SUCCESSFULLY);
    }
}
