import { createStore, applyMiddleware } from "redux";
import thunk from "redux-thunk";
import userlistReducer from "../reducers/userlist";

const logger = store => next => action => {
    console.log('dispatching', action);
    next(action);
    console.log('next state', store.getState());
};

const userListStore = createStore(userlistReducer, applyMiddleware(logger, thunk));

export default userListStore;
