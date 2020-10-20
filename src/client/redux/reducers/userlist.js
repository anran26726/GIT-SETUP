const initState = { isLoading: true, err: null, data: [] };

const userlistReducer = (state = initState, action) => {
    switch(action.type) {
        case "GET_USERLIST_START":
            return {
                ...state,
                isLoading: true
            };
        case "GET_USERLIST_SUCCESS":
            return {
                ...state,
                isLoading: false,
                data: action.payload,
                error: null
            };
        case "GET_USERLIST_ERROR":
            return {
                ...state,
                isLoading: false,
                error: action.error
            };
        default:
            return state;
    }
};

export default userlistReducer;
