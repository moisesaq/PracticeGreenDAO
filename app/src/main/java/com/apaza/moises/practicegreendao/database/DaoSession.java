package com.apaza.moises.practicegreendao.database;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.apaza.moises.practicegreendao.database.User;
import com.apaza.moises.practicegreendao.database.Place;
import com.apaza.moises.practicegreendao.database.Rating;

import com.apaza.moises.practicegreendao.database.UserDao;
import com.apaza.moises.practicegreendao.database.PlaceDao;
import com.apaza.moises.practicegreendao.database.RatingDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig placeDaoConfig;
    private final DaoConfig ratingDaoConfig;

    private final UserDao userDao;
    private final PlaceDao placeDao;
    private final RatingDao ratingDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        placeDaoConfig = daoConfigMap.get(PlaceDao.class).clone();
        placeDaoConfig.initIdentityScope(type);

        ratingDaoConfig = daoConfigMap.get(RatingDao.class).clone();
        ratingDaoConfig.initIdentityScope(type);

        userDao = new UserDao(userDaoConfig, this);
        placeDao = new PlaceDao(placeDaoConfig, this);
        ratingDao = new RatingDao(ratingDaoConfig, this);

        registerDao(User.class, userDao);
        registerDao(Place.class, placeDao);
        registerDao(Rating.class, ratingDao);
    }
    
    public void clear() {
        userDaoConfig.getIdentityScope().clear();
        placeDaoConfig.getIdentityScope().clear();
        ratingDaoConfig.getIdentityScope().clear();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public PlaceDao getPlaceDao() {
        return placeDao;
    }

    public RatingDao getRatingDao() {
        return ratingDao;
    }

}
