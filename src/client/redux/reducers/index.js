const initState = { isLoading: true, err: null, data: [] };

const reducer = (state = initState, action) => {
    switch(action.type) {
        case "GET_CITIES_START":
            return {
                ...state,
                isLoading: true
            };
        case "GET_CITIES_SUCCESS":
            return {
                ...state,
                isLoading: false,
                data: action.payload,
                error: null
            };
        case "GET_CITIES_ERROR":
            return {
                ...state,
                isLoading: false,
                error: action.error
            };
        default:
            return state;
    }
};

export default reducer;
