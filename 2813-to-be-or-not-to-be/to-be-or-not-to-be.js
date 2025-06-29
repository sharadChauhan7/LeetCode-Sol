/**
 * @param {string} val
 * @return {Object}
 */
var expect = function(val) {
    function toBe(v){
        if(v===val){
            return true;
        }
        throw new Error("Not Equal");
    }
    function notToBe(v){
        if(v!==val){
            return true;
        }
        throw new Error("Equal");
    }
    return {toBe,notToBe};
};

/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */